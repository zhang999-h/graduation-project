import {createRouter, createWebHistory} from 'vue-router'

import DraftView from "@/views/DraftView";
import LayoutView from "@/layout/LayoutView";
import LoginView from "@/views/LoginView";

import NoticeView from "@/views/NoticeView";
import NoticeDetailsView from "@/views/NoticeDetailsView";
import ApplicationView from "@/views/ApplicationView";
import AddAppView from "@/views/AddAppView";
import ApplicationDetailsView from "@/views/ApplicationDetailsView";
import CheckerLoginView from "@/views/CheckerLoginView";
import CheckView from "@/views/CheckView";


const routes = [
   // {path: "", redirect: "/statistics"},
    {
        path: '/',
        name: 'Layout',
        component: LayoutView,
        redirect:"/notice",

        children: [
            {
                path: '/applicationDetails',
                component: ApplicationDetailsView
            },
            {
                path: '/addApplication',
                component: AddAppView
            },
            {
                path: '/noticeDetails',
                component: NoticeDetailsView
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
                path: '/application',
                //name: 'Draft',
                component: ApplicationView
            },
            {
                path: '/check',
                //name: 'Draft',
                component: CheckView
            },
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: LoginView
    },
    {
        path: '/checkerLogin',

        component: CheckerLoginView
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
