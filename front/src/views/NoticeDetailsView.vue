<template>
  <div style="font-size: 30px;margin: 30px">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>通知</el-breadcrumb-item>
      <el-breadcrumb-item>正文</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
  <div style="font-size:30px;text-align: center;padding: 30px 0">
    {{Notice.title}}
  </div >
  <div style="text-align: center;padding: 30px 0;">
    时间：{{Notice.date}}
  </div>
  <div>
    <v-md-preview :text="Notice.content" style="margin-left: auto;margin-right: auto;width: 70%;"></v-md-preview>
  </div>
  <div>
    <a :href="Notice.fileUrl" style="margin-left: 250px">附件</a>
  </div>
</template>

<script>
import request from "@/utils/requset";

export default {
  name: "NoticeDetailsView",
  created() {

    request.get("/getNotice",{
      params:{
        id:this.$route.query.id
      }}).then(res=>{
      console.log(res)
      this.Notice=res.data

    })
  },
  data(){
    return {
      Notice: {
        title: '',
        content: '',
        file: '',

      },
    }
  },
  methods:{

  }
}
</script>

<style scoped>

</style>