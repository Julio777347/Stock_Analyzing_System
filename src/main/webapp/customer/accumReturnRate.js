/**
 * Created by chenyuyan on 1/6/17.
 */
var myChart = echarts.init(document.getElementById("accumReturnRate"));
var option = {
    title : {
        text: '累计收益率',

    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['策略','基准']
    },
    //右上角工具条
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['1','2','3','4','5','6','7']
        }
    ],
    yAxis : [
        {
            type : 'value',
            axisLabel : {
                formatter: '{value} °C'
            }
        }
    ],
    series : [
        {
            name:'策略',
            type:'line',
            data:[11, 11, 15, 13, 12, 13, 10],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },

        },
        {
            name:'基准',
            type:'line',
            data:[1, -2, 2, 5, 3, 2, 0],
            markPoint : {
                data : [
//                        {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
                    {type : 'min', name: '周最低'}
                ]
            },

        }
    ]
};

// 为echarts对象加载数据
myChart.setOption(option);

