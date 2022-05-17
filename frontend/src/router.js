
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PetManager from "./components/PetManager"

import CartItemManager from "./components/CartItemManager"
import ItemManager from "./components/ItemManager"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/pets',
                name: 'PetManager',
                component: PetManager
            },

            {
                path: '/cartItems',
                name: 'CartItemManager',
                component: CartItemManager
            },
            {
                path: '/items',
                name: 'ItemManager',
                component: ItemManager
            },



    ]
})
