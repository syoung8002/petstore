

<template>
<div>
  <h1 style = "margin-left:4.5%; margin-top:-10px; margin-bottom:20px;">Pet</h1>

    <v-row>
        <Pet :offline="offline" class="video-card" v-for="(item, index) in value" v-model="value[index]" v-bind:key="index" @delete="remove"/>
        <Pet :offline="offline" class="video-card" :isNew="true" :editMode="true" v-model="newValue" @add="append" v-if="tick"/>
    </v-row>
</div>




</template>

<script>

const axios = require('axios').default;
import Pet from './../Pet.vue';

export default {
  name: 'PetManager',

  components: {
    Pet
  },

  props: {
      value: Object,
      offline: Boolean
  },

  data: () => ({
    newValue: {},
    tick : true,
  }),

  async created() {

      if(this.offline){
          if(!this.value) this.value = [];
          return;
      } 

      var temp = await axios.get(axios.fixUrl('/pets'))

      this.value = temp.data._embedded.pets;

  },

  methods:{
    append(value){
      this.tick = false
      this.newValue = {}
      this.value.push(value)
      
      this.$emit('input', this.value);

      this.$nextTick(function(){
        this.tick=true
      })
    },

    remove(value){

      var where = -1;
      for(var i=0; i<this.value.length; i++){
        if(this.value[i]._links.self.href == value._links.self.href){
          where = i;
          break;
        }
      }

      if(where > -1){
        this.value.splice(i, 1);
        this.$emit('input', this.value);
      }
    }    
  }
};
</script>

<style>
  .video-card{width:300px; margin-left:4.5%; margin-top:50px; margin-bottom:50px;}
</style>
