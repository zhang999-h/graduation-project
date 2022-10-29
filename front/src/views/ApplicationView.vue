<template>
  <div style="margin-top: 50px ;width: 800px;margin-left: auto;margin-right: auto">

    <el-steps active="3">
      <el-step title="步骤 1" icon="edit" description="准备项目材料"></el-step>
      <el-step title="步骤 2" icon="upload" description="提交申报"></el-step>
      <el-step title="步骤 3" icon="picture" description="等待审核通过"></el-step>
    </el-steps>
  </div>
  <div style="margin-top: 50px ;width: 800px;margin-left: auto;margin-right: auto">
    <el-card v-for="item in Applications" class="box-card">
      <div slot="header" class="clearfix">
        <span style="color: cornflowerblue">{{ item.appTime }} &emsp;&emsp;</span> <span>{{ item.title }}</span>
        &emsp;&emsp;
        <el-tag type="primary" v-if="item.state==0">未审核</el-tag>
        <el-tag type="error" v-if="item.state==1">未通过</el-tag>
        <el-tag type="success" v-if="item.state==2">通过</el-tag>
        <router-link :to="{path:'/applicationDetails',query:{appid:item.id} }" style="color: black">
          <el-button style="float: right; margin-top: 0px; margin-left: 20px" type="text">查看</el-button>
        </router-link>
<!--        <el-button style="float: right;  margin-left: 20px" type="text">编辑</el-button>-->
<!--        <el-button style="color:red;float: right;  margin-left: 20px" type="text">删除</el-button>-->

<!--          <el-button style="color:red;float: right;  margin-left: 20px" type="text" @click="handleEdit()">-->
<!--            编辑-->
<!--          </el-button>-->
          <el-popconfirm title="确认删除吗?" @confirm="handleDel(item.id)" v-if="item.state==0">
            <template #reference>
              <el-button style="float: right; margin-top: 0px; margin-right: 20px;color: red" type="text">删除</el-button>
            </template>
          </el-popconfirm>

      </div>

    </el-card>
    <div style="float: right;margin-right: 20px;margin-top: 50px;">
      <router-link to="/addApplication">
        <el-button type="primary">
          新增
        </el-button>
      </router-link>
    </div>
  </div>

</template>

<script>
import request from "@/utils/requset";

export default {
  name: "ApplicationView",
  data() {
    return {
      Applications: [],

    }
  },
  methods: {

    load() {
      request.get("/getApplicationByTeacher"
      ).then(res => {

        this.Applications = res.data


      })
      console.log(this.State)
    },
    handleDel(id) {
      console.log(id)
      request.delete("/delApp/" + id)
          .then(res => {
            if (res.code === '0') {
              this.$message({
                type: "success",
                message: "删除成功"
              })
            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
            this.load()
          })
    },
  },
  created() {

    this.load()

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
</style>
