<template>
  <div>
  <table>
    <tr>
      <td>
      <div id="main" style="width: 500px; height: 400px"></div>
      </td>
      <td>
      <div id="pie" style="width: 500px; height: 400px"></div>
      </td>
    </tr>
    </table>
  </div>

</template>

<script>
import * as echarts from 'echarts'
import request from "@/utils/requset";
export default {
  name: 'StatisticsView',
  components: {
    
  },
  data(){
      return {

      }
  },
  mounted() {
    var chartDom = document.getElementById('main');
    var myChart = echarts.init(chartDom);
    var option;

    option = {
      title: {
        text: '近7日申报情况',
        subtext: '折线图',
        left: 'center'
      },
      xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: [0,2, 3, 0, 2, 1, 1],
          type: 'line'
        }
      ]
    };

    option && myChart.setOption(option);


    var pieDom = document.getElementById('pie');
    var pieChart = echarts.init(pieDom);
    var pieOption;

    pieOption = {
      title: {
        text: '审核情况',
        subtext: '比例图',
        left: 'center'
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        orient: 'vertical',
        left: 'left'
      },
      series: [
        {
          name: 'Access From',
          type: 'pie',
          radius: '50%',
          data: [
          ],
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }
      ]
    };

    request.get("/pie").then(res => {

      pieOption.series[0].data = [
        {name: "未审核", value: res.data[0]},
        {name: "通过", value: res.data[2]},
        {name: "未通过", value: res.data[1]},
      ]
      pieChart.setOption(pieOption)
    })


  }
}
</script>
