import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'
import StatisticsView from '../views/StatisticsView.vue'
import QueryView from "@/views/QueryView";
import DraftView from "@/views/DraftView";
import TeacherView from "@/views/TeacherView";
import LayoutView from "@/layout/LayoutView";
import LoginView from "@/views/LoginView";
import CheckerView from "@/views/CheckerView";
import NoticeView from "@/views/NoticeView";
import NoticeDetailsView from "@/views/NoticeDetailsView";
import ManageView from "@/views/ManageView";

const routes = [
   // {path: "", redirect: "/statistics"},
    {
        path: '/',
        name: 'Layout',
        component: LayoutView,
        redirect:"/statistics",

        children: [
            {
                path: '/manage',
                component: ManageView
            },
            {
                path: '/noticeDetails',
                component: NoticeDetailsView
            },
            {
                path: '/statistics',
                //name: 'Statistics',
                component: StatisticsView
            },
            {
                path: '/query',
                //name: 'Query',
                component: QueryView
            },
            {
                path: '/draft',
                //name: 'Draft',
                component: DraftView
            },
            {
                path: '/notice',
                //name: 'Draft',
                component: NoticeView
            },
            {
                path: '/teacher',
                //name: 'Teacher',
                component: TeacherView
            },
            {
                path: '/checker',

                component: CheckerView
            },
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: LoginView
    },

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
