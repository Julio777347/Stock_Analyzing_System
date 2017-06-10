package stocking.data_impl;

import net.sf.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import stocking.data_service.DataFactory_Data_Service;
import stocking.data_service.GetNews_Data_Service;
import stocking.po.NewsPO;

import static org.junit.Assert.assertEquals;

/**
 * Created by xjwhhh on 2017/6/5.
 */
public class GetNews_Data_ImplTest {
    DataFactory_Data_Service dataFactory_data_service;
    GetNews_Data_Service getNews_data_service;

    @Before
    public void init() {
        dataFactory_data_service = DataFactory_Data_Impl.getInstance();
        getNews_data_service = dataFactory_data_service.getNews();
    }

    @Test
    public void getMarketNews() throws Exception {
        NewsPO newsPO = getNews_data_service.getMarketNews();
        JSONObject json = JSONObject.fromObject(newsPO);//将java对象转换为json对象
        String str = json.toString();//将json对象转换为字符串
        String needStr = "{\"classify\":[\"证券\",\"美股\",\"证券\",\"证券\",\"美股\",\"证券\",\"证券\",\"证券\",\"证券\",\"证券\",\"美股\",\"证券\",\"证券\",\"证券\",\"证券\",\"证券\",\"美股\",\"国内财经\",\"证券\",\"证券\",\"国内财经\",\"美股\",\"国内财经\",\"证券\",\"证券\",\"证券\",\"美股\",\"证券\",\"证券\",\"国内财经\",\"国内财经\",\"美股\",\"国内财经\",\"国内财经\",\"外汇\",\"美股\",\"证券\",\"外汇\",\"外汇\",\"美股\",\"外汇\",\"证券\",\"证券\",\"证券\",\"证券\",\"港股\",\"证券\",\"证券\",\"证券\",\"美股\"],\"time\":[\"06-08 21:38\",\"06-08 21:34\",\"06-08 21:34\",\"06-08 21:31\",\"06-08 21:27\",\"06-08 21:16\",\"06-08 21:14\",\"06-08 21:04\",\"06-08 21:00\",\"06-08 21:00\",\"06-08 20:40\",\"06-08 20:37\",\"06-08 20:31\",\"06-08 20:07\",\"06-08 20:00\",\"06-08 20:00\",\"06-08 19:58\",\"06-08 19:53\",\"06-08 19:15\",\"06-08 19:13\",\"06-08 19:12\",\"06-08 19:08\",\"06-08 19:01\",\"06-08 18:52\",\"06-08 18:51\",\"06-08 18:49\",\"06-08 18:49\",\"06-08 18:46\",\"06-08 18:45\",\"06-08 18:42\",\"06-08 18:37\",\"06-08 18:33\",\"06-08 18:22\",\"06-08 18:17\",\"06-08 18:06\",\"06-08 18:04\",\"06-08 18:03\",\"06-08 18:03\",\"06-08 17:58\",\"06-08 17:57\",\"06-08 17:54\",\"06-08 17:50\",\"06-08 17:45\",\"06-08 17:34\",\"06-08 17:30\",\"06-08 17:30\",\"06-08 17:29\",\"06-08 17:24\",\"06-08 17:23\",\"06-08 17:21\"],\"title\":[\"新都退连续十跌停 广东系营业部胜利逃亡\",\"开盘：美股周四高开 纳指创历史新高\",\"白马股发力：今年以来231只股票创股灾以来新高\",\"兜底增持遭遇防忽悠大招 要披露员工薪酬、资金来源\",\"欧银鹰爪欲露还缩 QE运转维持现状欧元失去保护伞\",\"海航投资：延长定增有效期议案遭股东大会否决\",\"吹过的世纪大牛股：千亿市值梦的百润股份如今跌出翔\",\"龙生股份：策划一场19个涨停的屠杀 需要多少位神秘人\",\"明明是现金牛 为何李嘉诚想沽售！\",\"“开完嘿店又来借钱”顺丰缺啥补啥的套路还要玩多久\",\"盘前：欧央行维持利率不变 美期指微升\",\"韩建河山：监事拟减持逾11万股改善生活\",\"深交所追问*ST准油 要求回应媒体所报道各方是否存在关…\",\"三泰控股子公司速递易重组:中邮牵头 拟引菜鸟等参股\",\"最被看好的十大港股：大和给予吉利“跑赢大市”评级\",\"李小加：债券通助力香港建设国际风险管理中心\",\"莱迪思交易背后隐现中国身影 静待美国监管审批\",\"一行三会规划十三五金融业标准体系 推进互金国际标准化\",\"棕榈股份公布20亿建养生小镇利好 股价尾盘狂飙或涉老鼠…\",\"涨停板早知道：七大利好明日有望发酵\",\"中国螺纹钢被巴基斯坦认定为倾销 2年内6起钢材调查\",\"6月8日19点交易员正关注要闻\",\"这个政策一出 一批企业将起死回生\",\"万科：钜盛华将9100万股A股押给渤海国际信托\",\"深交所：增持倡议书应披露员工薪酬与资金来源\",\"6月8日上市公司晚间公告速递\",\"阿里盘前大涨10%或登顶中国市值最大公司\",\"世纪游轮9日起更名为巨人网络 定位综合性互联网企业\",\"*ST云网：孟凯未接受媒体采访 警示股价涨幅较大风险\",\"李克强：继续放宽市场准入 推进负面清单管理模式\",\"兑现万亿减税降费承诺是总理给市场的最好预期\",\"今年前5个月中俄贸易额同比增长33.7%\",\"5月进口明显好于预期 专家:再验证中国经济L型拐点已过\",\"雄安户籍含金量超北京？央企若搬迁员工很难放弃京籍\",\"AETOS艾拓思:美元指数止跌企稳 英镑走高黄金回调\",\"马来西亚打算向游客征旅游税\",\"中矿资源：控股股东拟增持不超1% 股东国腾投资承诺不减…\",\"牛汇:黄金正式进入疯狂48小时 你做好准备了吗\",\"邦达亚洲:超级星期四重磅来袭 市场现暴风雨前宁静\",\"响应一带一路倡议 中信入主哈萨克斯坦阿尔金银行\",\"汇生财富:日内大事件一触即发 投资者请系好安全带\",\"“特色小镇”关注度提升 四主线把握投资机会\",\"港媒称神华国电或联姻：中国拟打造煤电行业巨头\",\"5只精选个股获明星营业部买入 一股成功率达81%\",\"时隔23个月后恒指上26000 关注今夜重要事件\",\"港股稳站二万六点收市 近两年来首次\",\"上交所：将调整上证一带一路主题等指数样本股\",\"易联众：正积极参与第三代社保卡的发行\",\"一套房救一家上市公司：S*ST前锋收1125万元扭亏为…\",\"今后20年C919这一类型飞机需求为1.5万架\"],\"url\":[\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzhac0603676.shtml\",\"http://finance.sina.com.cn/stock/usstock/c/2017-06-08/doc-ifyfzhac0602882.shtml\",\"http://finance.sina.com.cn/stock/marketresearch/2017-06-08/doc-ifyfzfyz2496998.shtml\",\"http://finance.sina.com.cn/stock/t/2017-06-08/doc-ifyfzfyz2496346.shtml\",\"http://finance.sina.com.cn/stock/usstock/c/2017-06-08/doc-ifyfzfyz2495372.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzfyz2493020.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzhac0598454.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzhac0595555.shtml\",\"http://cj.sina.com.cn/article/detail/2972154552/278134\",\"http://cj.sina.com.cn/article/detail/2972154552/278128\",\"http://finance.sina.com.cn/stock/usstock/c/2017-06-08/doc-ifyfzhac0589808.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzhac0589024.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzhac0588068.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzhac0582301.shtml\",\"http://cj.sina.com.cn/article/detail/2418201593/278040\",\"http://cj.sina.com.cn/article/detail/2418201593/278038\",\"http://finance.sina.com.cn/stock/usstock/c/2017-06-08/doc-ifyfzhac0580327.shtml\",\"http://finance.sina.com.cn/roll/2017-06-08/doc-ifyfzaaq5710117.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzhac0571112.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzfyz2464749.shtml\",\"http://finance.sina.com.cn/china/gncj/2017-06-08/doc-ifyfzhpq6253087.shtml\",\"http://finance.sina.com.cn/stock/usstock/c/2017-06-08/doc-ifyfzhac0569316.shtml\",\"http://finance.sina.com.cn/china/gncj/2017-06-08/doc-ifyfzhac0567586.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzfyz2459314.shtml\",\"http://finance.sina.com.cn/stock/y/2017-06-08/doc-ifyfzhac0564945.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzhac0564476.shtml\",\"http://finance.sina.com.cn/stock/usstock/c/2017-06-08/doc-ifyfzhac0564370.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzfyz2457886.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzfyz2457552.shtml\",\"http://finance.sina.com.cn/roll/2017-06-08/doc-ifyfzaaq5702750.shtml\",\"http://finance.sina.com.cn/roll/2017-06-08/doc-ifyfzaaq5701832.shtml\",\"http://finance.sina.com.cn/stock/usstock/c/2017-06-08/doc-ifyfzhac0559819.shtml\",\"http://finance.sina.com.cn/china/gncj/2017-06-08/doc-ifyfzhpq6247251.shtml\",\"http://finance.sina.com.cn/china/gncj/2017-06-08/doc-ifyfzhpq6246719.shtml\",\"http://finance.sina.com.cn/money/forex/forexfxyc/2017-06-08/doc-ifyfzhac0550780.shtml\",\"http://finance.sina.com.cn/stock/usstock/c/2017-06-08/doc-ifyfzfyz2443553.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzfyz2443084.shtml\",\"http://finance.sina.com.cn/money/forex/forexfxyc/2017-06-08/doc-ifyfzhac0548974.shtml\",\"http://finance.sina.com.cn/money/forex/forexfxyc/2017-06-08/doc-ifyfzhac0547313.shtml\",\"http://finance.sina.com.cn/stock/usstock/c/2017-06-08/doc-ifyfzfyz2440801.shtml\",\"http://finance.sina.com.cn/money/forex/forexfxyc/2017-06-08/doc-ifyfzfyz2439825.shtml\",\"http://finance.sina.com.cn/stock/marketresearch/2017-06-08/doc-ifyfzhac0544269.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzhac0542426.shtml\",\"http://finance.sina.com.cn/stock/zldx/2017-06-08/doc-ifyfzfyz2431893.shtml\",\"http://cj.sina.com.cn/article/detail/5115326071/277762\",\"http://finance.sina.com.cn/stock/hkstock/marketalerts/2017-06-08/doc-ifyfzhac0536225.shtml\",\"http://finance.sina.com.cn/stock/marketresearch/2017-06-08/doc-ifyfzhac0535705.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzhac0533193.shtml\",\"http://finance.sina.com.cn/stock/s/2017-06-08/doc-ifyfzhpq6239140.shtml\",\"http://finance.sina.com.cn/stock/usstock/c/2017-06-08/doc-ifyfzhac0532287.shtml\"]}";
        assertEquals(needStr, str);
    }

    @Test
    public void getSingleNews() throws Exception {
        NewsPO newsPO = getNews_data_service.getSingleNews("000001");
        JSONObject json = JSONObject.fromObject(newsPO);//将java对象转换为json对象
        String str = json.toString();//将json对象转换为字符串
        String needStr = "{\"classify\":[\"临时公告\",\"临时公告\",\"临时公告\",\"临时公告\",\"临时公告\",\"临时公告\",\"临时公告\",\"临时公告\",\"一季度报告（摘要）\",\"一季度报告\",\"临时公告\",\"临时公告\",\"临时公告\",\"临时公告\",\"券商报告\",\"券商报告\",\"公司章程\",\"临时公告\",\"临时公告\",\"临时公告\",\"临时公告\",\"临时公告\",\"年度报告（摘要）\",\"年度报告\",\"临时公告\",\"临时公告\",\"临时公告\",\"临时公告\",\"临时公告\",\"临时公告\"],\"time\":[\"2017-06-09\",\"2017-06-09\",\"2017-06-09\",\"2017-06-09\",\"2017-06-09\",\"2017-05-13\",\"2017-04-22\",\"2017-04-22\",\"2017-04-22\",\"2017-04-22\",\"2017-03-27\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\",\"2017-03-17\"],\"title\":[\"平安银行：关于召开2016年年度股东大会的通知\",\"平安银行：关于发行金融债券获准的公告\",\"平安银行：独立董事相关独立意见\",\"平安银行：董事会决议公告\",\"平安银行：2016年年度股东大会文件\",\"平安银行：关于副行长任职资格核准的公告\",\"平安银行：监事会决议公告\",\"平安银行：董事会决议公告\",\"平安银行：2017年第一季度报告正文\",\"平安银行：2017年第一季度报告全文\",\"平安银行：澄清公告\",\"平安银行：内部控制审计报告\",\"平安银行：监事会决议公告\",\"平安银行：监事会对本行2016年度内部控制自我评价报告的意见\",\"平安银行：国泰君安证券股份有限公司、平安证券股份有限公司关于公司2016年度募集资金存放与实际使用情况的核查意见\",\"平安银行：国泰君安证券股份有限公司、平安证券股份有限公司关于公司2016年度保荐工作报告\",\"平安银行：公司章程（2017年3月）\",\"平安银行：独立董事相关独立意见\",\"平安银行：董事会决议公告\",\"平安银行：2016年投资者保护工作情况报告\",\"平安银行：2016年企业社会责任报告\",\"平安银行：2016年年度审计报告\",\"平安银行：2016年年度报告摘要\",\"平安银行：2016年年度报告\",\"平安银行：2016年度内部控制自我评价报告\",\"平安银行：2016年度募集资金存放与实际使用情况专项报告及鉴证报告\",\"平安银行：2016年度募集资金存放与实际使用情况专项报告\",\"平安银行：2016年度控股股东及其他关联方占用资金情况专项报告\",\"平安银行：2016年度监事会工作报告\",\"平安银行：2016年度独立董事述职报告\"],\"url\":[\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3479618\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3479617\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3479616\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3479615\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3479614\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3403346\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3278011\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3278010\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3278009\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3278008\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3146714\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116736\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116735\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116734\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116733\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116732\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116731\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116730\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116729\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116728\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116727\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116726\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116725\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116724\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116723\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116722\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116720\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116718\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116716\",\"http://vip.stock.finance.sina.com.cn/corp/view/vCB_AllBulletinDetail.php?CompanyCode=10000590&gather=1&id=3116714\"]}";
        assertEquals(needStr, str);
    }

}