
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PetManager from "./components/PetManager"

import ItemManager from "./components/ItemManager"
import CartItemManager from "./components/CartItemManager"

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
                path: '/items',
                name: 'ItemManager',
                component: ItemManager
            },
            {
                path: '/cartItems',
                name: 'CartItemManager',
                component: CartItemManager
            },



    ]
})
