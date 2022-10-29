<template>
  <div style="width:100px;margin-top:50px;margin-left: auto;margin-right: auto">
    <router-link to="/draft">
      <el-button type="primary" round>增加通知</el-button>
    </router-link>
  </div>


  <div class="my_table"
       style="width: 700px;margin-top:50px;margin-left: auto;margin-right: auto">
    <el-table :data="Notices" style="width: 100%">
      <el-table-column
          prop="date"
          width="180"
          column-key="date"
      />
      <el-table-column prop="title" label="" >
        <template #default="scope">
          <router-link :to="{path:'/noticeDetails',query:{id:scope.row.id} }" style="color: black">
            {{scope.row.title}}
          </router-link>
        </template>
      </el-table-column>
      <el-table-column label="" width="180">
        <template #default="scope">
          <el-popconfirm title="确认删除吗?" @confirm="handleDel(scope.row.id)">
            <template #reference>
              <el-button type="text">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import request from "@/utils/requset";

export default {
  name: "NoticeView",
  data() {
    return {
      Notices: [],
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
</style>