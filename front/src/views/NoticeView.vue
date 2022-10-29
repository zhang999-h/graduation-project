<template>
  <div>
    <el-carousel :interval="4000" type="card" height="200px">
      <el-carousel-item v-for="item in imgArray" :key="item">
        <img :src="item.url" style="width: 100%;height: 100%">
<!--        <h3 class="medium">{{ item }}</h3>-->
      </el-carousel-item>
    </el-carousel>
  </div>

  <table>
    <tr>
      <td>
      <div style="margin-left: 200px">
        <el-timeline>
          <el-timeline-item
              v-for="(activity, index) in activities"
              :key="index"
              :icon="activity.icon"
              :type="activity.type"
              :color="activity.color"
              :size="activity.size"
              :timestamp="activity.timestamp">
            {{ activity.content }}
          </el-timeline-item>
        </el-timeline>
      </div>
      </td>
      <td>
      <div class="my_table"
           style="width: 600px;margin-left: 310px;margin-right: auto">
        <el-table :data="Notices" style="width: 100%">
          <el-table-column
              prop="date"
              width="180"
              column-key="date"
          />
          <el-table-column prop="title" label="">
            <template #default="scope">
              <router-link :to="{path:'/noticeDetails',query:{id:scope.row.id} }" style="color: black">
                {{ scope.row.title }}
              </router-link>
            </template>
          </el-table-column>

        </el-table>
      </div>
      </td>
    </tr>
  </table>
</template>

<script>
import request from "@/utils/requset";

export default {
  name: "NoticeView",

  data() {
    return {
      imgArray: [
        {url:require('../assets/背景.jpg')},
        {url:require('../assets/banner1.jpg')},
        {url:require('../assets/banner2.jpg')},
        {url:require('../assets/banner3.jpg')},
      ],

      Notices: [],
      activities: [{
        content: '申报开始时间',
        timestamp: '',
        size: 'large',
        type: 'primary',
        icon: 'el-icon-more',
        color: '#0bbd87'
      }, {
        content: '审批开始时间',
        timestamp: '',
        color: ''
      }, {
        content: '申报结束时间',
        timestamp: '',
        size: 'large'
      }, {
        content: '审批结束时间',
        timestamp: ''
      }],
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      request.get("/searchNotice"
      ).then(res => {
        console.log(res)
        this.Notices = res.data
      })
      request.get("/getDate"
      ).then(res => {
        console.log(res)
        this.activities[0].timestamp=res.data.appStartDate
        this.activities[1].timestamp=res.data.checkStartDate
        this.activities[2].timestamp=res.data.appEndDate
        this.activities[3].timestamp=res.data.checkEndDate
      })
    },
  }
}
</script>

<style scoped>
.router-link-active {
  text-decoration: none;
  color: yellow;
}

a {
  text-decoration: none;
  color: white;
}

.my_table >>> .el-table__row > td {
  /* 去除表格线 */
  border: none;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>