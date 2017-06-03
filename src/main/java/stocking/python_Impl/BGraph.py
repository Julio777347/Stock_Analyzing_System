import pymysql
import sys
import pandas as pd


def getStockInfo(code, startDate, endDate):
    section = getSectionByCode(code)
    sql = "select distinct date,adjclose from kdata_" + section + " where date>='%s' and date<='%s' and code='%s' order by date" % (
        startDate, endDate, code)
    try:
        cursor.execute(sql)
        results = cursor.fetchall()
        re = []
        for row in results:
            date = row[0]
            close = row[1]
            resultlist = [date, close]
            re.append(resultlist)
        df = pd.DataFrame(re, columns=['date', code])
        df = df.set_index('date')
    except:
        print('get data fail')
    return df


def getSectionByCode(code):
    subcode = code[:3]
    if subcode == "600":
        section = "sha0"
    elif subcode == "601":
        section = "sha1"
    elif subcode == "603":
        section = "sha3"
    elif subcode == "900":
        section = "shb"
    elif subcode == "000":
        section = "sza"
    elif subcode == "200":
        section = "szb"
    elif subcode == "300":
        section = "cyb"
    elif subcode == "002":
        section = "zxb"
    else:
        section = "无"
    return section


if __name__ == "__main__":
    db = pymysql.connect("localhost", "root", "123456", "stock", charset="utf8")
    cursor = db.cursor();
    paths = sys.argv[0].split("/")
    newPath = ""
    for i in range(0, len(paths) - 2):
        newPath += (paths[i] + "\\")
    newPath += "calculation"
    sys.path.append(newPath)
    sys.path.append(
        "C:\\Users\\xjwhh\\IdeaProjects_Ultimate\\Stock_Analyzing_System\\src\\main\\java\\stocking\\calculation")
    import bGraph

    ff = open("C:\\Users\\xjwhh\\Desktop\\t.txt", 'a')
    # value = sys.argv[1]
    #
    # values = value.split("?")
    #
    # strategyType = int(values[0])  # 策略类型
    # startDate = values[1]  # 开始日期
    # endDate = values[2]  # 结束日期
    # isHold = int(values[3])  # s是否是形成期
    # interval = int(values[4])  # 已知时间
    # isPla = int(values[5])  # 是否为板块
    # stocks = values[6]
    # stockLists = stocks.split("/")  # 股票代码列表

    # strategyType = sys.argv[1]  # 策略类型
    # startDate = sys.argv[2]  # 开始日期
    # endDate = sys.argv[3]  # 结束日期
    # isHold = sys.argv[4]
    # interval = sys.argv[5]
    # isPla = sys.argv[6]  # 是否为板块
    # stocks = sys.argv[7]
    # stockLists = stocks.split("/")  # 股票代码列表

    strategyType = 1  # 策略类型
    startDate = "2016-03-01"  # 开始日期
    endDate = "2016-05-01"  # 结束日期
    isHold=1

    interval=20
    isPla = 1  # 是否为板块
    plaName = " "
    stockLists=['沪深300']
    # # stocks = sys.argv[7]
    # stockLists = ["000001",
    #               "000002",
    #               "000004",
    #               "000005",
    #               "000006",
    #               "000007",
    #               "000008",
    #               "000009",
    #               "000010",
    #               "000011",
    #               "000012",
    #               "000014",
    #               "000016",
    #               "000017",
    #               "000018",
    #               "000019",
    #               "000020",
    #               "000021",
    #               "000022",
    #               "000023",
    #               "000025",
    #               "000026"]  # 股票代码列表

    if isPla == 1:
        isPla = True
        plaName = stockLists[0]
    else:
        isPla = False
        plaName = " "

    if isHold == 1:
        isHold = True
    else:
        isHold = False

    ff.write("\n")
    ff.write(str(strategyType))
    ff.write(startDate)
    ff.write(endDate)
    # ff.write(str(form))
    # ff.write(str(hold))
    ff.write(str(isPla))
    # ff.write(stocks)
    ff.write("\n")

    code = stockLists[0]
    finalDF = getStockInfo(code=code, startDate=startDate, endDate=endDate)

    for i in range(1, len(stockLists)):
        code = stockLists[i]
        df = getStockInfo(code=code, startDate=startDate, endDate=endDate)
        finalDF = finalDF.join(df)
    finalDF.dropna(axis=1, how="any", inplace=True)  # 去除有nan值的列

    bgraph = bGraph.BGraph()
    bgraph.count(finalDF, isPla, plaName, strategyType, isHold, interval)
    profits = bgraph.profits
    # print(type(profits))
    print(len(profits))
    for value in profits:
        print(value)
    winChance = bgraph.winChance
    for value in winChance:
        print(value)
