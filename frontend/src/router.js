
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderOrderManager from "./components/listers/OrderOrderCards"
import OrderOrderDetail from "./components/listers/OrderOrderDetail"

import StoreownerCookManager from "./components/listers/StoreownerCookCards"
import StoreownerCookDetail from "./components/listers/StoreownerCookDetail"

import RiderDeliveryManager from "./components/listers/RiderDeliveryCards"
import RiderDeliveryDetail from "./components/listers/RiderDeliveryDetail"




export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders/orders',
                name: 'OrderOrderManager',
                component: OrderOrderManager
            },
            {
                path: '/orders/orders/:id',
                name: 'OrderOrderDetail',
                component: OrderOrderDetail
            },

            {
                path: '/storeowners/cooks',
                name: 'StoreownerCookManager',
                component: StoreownerCookManager
            },
            {
                path: '/storeowners/cooks/:id',
                name: 'StoreownerCookDetail',
                component: StoreownerCookDetail
            },

            {
                path: '/riders/deliveries',
                name: 'RiderDeliveryManager',
                component: RiderDeliveryManager
            },
            {
                path: '/riders/deliveries/:id',
                name: 'RiderDeliveryDetail',
                component: RiderDeliveryDetail
            },





    ]
})
