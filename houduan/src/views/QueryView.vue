<template>
  <div style="margin:10px">
    申报人：
    <el-input v-model="searchName" placeholder="Please input" style="width: 20%;"/>
    题目：
    <el-input v-model="searchTitle" placeholder="Please input" style="width: 20%;"/>
    状态：
    <el-select v-model="searchState" class="m-2" placeholder="Select">
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
      />
    </el-select>
    <el-button  @click="load" style="margin:10px">查询</el-button>
    <el-button @click="clear()" style="margin:10px">清除查询条件</el-button>


  </div>
<!--表-->
  <el-table  :data="Application" style="width: 100%">
    <el-table-column type="selection" width="55" />
    <el-table-column
        prop="appTime"
        label="提交日期"
        sortable
        width="180"
        column-key="date"
    />
    <el-table-column prop="teacherName" label="申報人" width="180"/>
    <el-table-column prop="title" label="题目" show-overflow-tooltip="true" :formatter="formatter"/>
    <el-table-column prop="checkerName" label="处理人" :formatter="formatter"/>
<!--    <el-table-column sortable prop="checkerTime" label="处理时间" :formatter="formatter"/>-->
    <el-table-column
        prop="state"
        label="状态"
        width="100"
    >
      <template #default="scope">
        <el-tag type="primary" v-if="scope.row.state==0">未审核</el-tag>
        <el-tag type="error" v-if="scope.row.state==1">未通过</el-tag>
        <el-tag type="success" v-if="scope.row.state==2">通过</el-tag>

      </template>
    </el-table-column>
  </el-table>
<!--分页-->
  <div class="demo-pagination-block" style="margin: 10px 0">
    <div class="demonstration"></div>
    <el-pagination
        v-model:currentPage="currentPage"
        v-model:page-size="pageSize"
        :page-sizes="[5, 10, 15]"
        :small="small"
        :disabled="disabled"
        :background="background"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
    />
  </div>
</template>
<script>
import request from "@/utils/requset";

export default {
  name: "QueryView",
  data() {
    return {
      options:[
        {
          value: '0',
          label: '未审核',
        },
        {
          value: '1',
          label: '未通过',
        },
        {
          value: '2',
          label: '通过',
        },
      ],
      searchName: '',
      searchTitle:'',
      searchState:'',
      Application:[],
    }
  },
  created() {
    this.load()
  },
  methods:{
    load(){
      request.get("/searchApplication",{
        params:{
          pageNum:this.currentPage,
          pageSize:this.pageSize,
          searchName:this.searchName,
          searchTitle:this.searchTitle,
          searchState:this.searchState
        }
      }).then(res=>{
        this.Application=res.data.records
        this.total=res.data.total
      })
    },
    clear(){
      this.searchName='',
          this.searchTitle='',
          this.searchState='',
          this.load()
    },
    handleSizeChange() {
      this.load()
    },
    handleCurrentChange() {
      this.load()
    },
  }
}
</script>
<!--<script lang="ts" setup>-->


<!--import { ref } from 'vue'-->
<!--import type { TableColumnCtx } from 'element-plus/es/components/table/src/table-column/defaults'-->
<!--import type { ElTable } from 'element-plus'-->

<!--interface User {-->
<!--  date: string-->
<!--  name: string-->
<!--  address: string-->
<!--  tag: string-->
<!--}-->

<!--const tableRef = ref<InstanceType<typeof ElTable>>()-->

<!--const resetDateFilter = () => {-->
<!--  tableRef.value!.clearFilter(['date'])-->
<!--}-->
<!--// TODO: improvement typing when refactor table-->
<!--const clearFilter = () => {-->
<!--  // eslint-disable-next-line @typescript-eslint/ban-ts-comment-->
<!--  // @ts-expect-error-->
<!--  tableRef.value!.clearFilter()-->
<!--}-->
<!--const formatter = (row: User, column: TableColumnCtx<User>) => {-->
<!--  return row.address-->
<!--}-->
<!--const filterTag = (value: string, row: User) => {-->
<!--  return row.tag === value-->
<!--}-->
<!--const filterHandler = (-->
<!--    value: string,-->
<!--    row: User,-->
<!--    column: TableColumnCtx<User>-->
<!--) => {-->
<!--  const property = column['property']-->
<!--  return row[property] === value-->
<!--}-->

<!--const tableData: User[] = [-->
<!--  {-->
<!--    date: '2016-05-03',-->
<!--    name: 'Tom',-->
<!--    address: 'No. 189, Grove St, Los Angeles',-->
<!--    tag: 'Home',-->
<!--  },-->
<!--  {-->
<!--    date: '2016-05-02',-->
<!--    name: 'Tom',-->
<!--    address: 'No. 189, Grove St, Los Angeles',-->
<!--    tag: 'Office',-->
<!--  },-->
<!--  {-->
<!--    date: '2016-05-04',-->
<!--    name: 'Tom',-->
<!--    address: 'No. 189, Grove St, Los Angeles',-->
<!--    tag: 'Home',-->
<!--  },-->
<!--  {-->
<!--    date: '2016-05-01',-->
<!--    name: 'Tom',-->
<!--    address: 'No. 189, Grove St, Los Angeles',-->
<!--    tag: 'Office',-->
<!--  },-->
<!--]-->
<!--</script>-->

