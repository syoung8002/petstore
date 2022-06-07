
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PetManager from "./components/listers/PetCards"

import ItemManager from "./components/listers/ItemList"
import Home from "./components/Home"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/',
                name: 'Home',
                component: Home
            },
            {
                path: '/pets',
                name: 'PetManager',
                component: PetManager
            },

            {
                path: '/items',
                name: 'ItemManager',
                component: ItemManager
            },



    ]
})
