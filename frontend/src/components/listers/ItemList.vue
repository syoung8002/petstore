

<template>

<div>
  <h1 style = "margin-left:4.5%; margin-top:-10px; margin-bottom:20px;">Item</h1>
              <v-list two-line>
                <template  v-for="(value, n) in values">
                  <v-list-item

                    :key="n"
                  >
                    <v-list-item-avatar color="grey darken-1">
                    </v-list-item-avatar>

                    <v-list-item-content>
                      <v-list-item-title>Message </v-list-item-title>





                      <v-list-item-subtitle>

            Id :  {{value.id }} * 
            Pet :  {{value.pet }} * 
            Price :  {{value.price }} * 

                      </v-list-item-subtitle>
                    </v-list-item-content>
                  </v-list-item>

                  <v-divider
                    v-if="n !== 6"
                    :key="`divider-${n}`"
                    inset
                  ></v-divider>
                </template>
              </v-list>




                  <Item class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>

  </div>



</template>

<script>

const axios = require('axios').default;
import Item from './../Item.vue';

export default {
  name: 'ItemManager',

  components: {
    Item
  },

  data: () => ({
    values: [],
    newValue: {},
    tick : true,
  }),

  async created() {
      var temp = await axios.get(axios.fixUrl('/items'))

      this.values = temp.data._embedded.items;

  },

  methods:{
    append(value){
      this.tick = false
      this.newValue = {}
      this.values.push(value)
      
      this.$nextTick(function(){
        this.tick=true
      })
    },

    remove(value){

      var where = -1;
      for(var i=0; i<this.values.length; i++){
        if(this.values[i]._links.self.href == value._links.self.href){
          where = i;
          break;
        }
      }

      if(where > -1){
        this.values.splice(i, 1);
      }
    }    
  }
};
</script>

<style>
  .video-card{width:300px; margin-left:4.5%; margin-top:50px; margin-bottom:50px;}
</style>
