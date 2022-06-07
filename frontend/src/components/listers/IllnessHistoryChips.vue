

<template>

<div>
  <h2 style = "margin-left:6%; margin-top:0px; margin-bottom:20px;">IllnessHistory</h2>
              <v-list two-line>
                <template  v-for="(item, n) in value">
                  <v-list-item

                    :key="n"
                  >
                    <v-list-item-avatar color="grey darken-1">
                    </v-list-item-avatar>

                    <v-list-item-content>
                      <v-list-item-title>Message </v-list-item-title>





                      <v-list-item-subtitle>

            IllName :  {{item.illName }} * 
            Start :  {{item.start }} * 
            End :  {{item.end }} * 

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

              <IllnessHistory v-if="editMode && tick" offline inList class="video-card" :isNew="true" editMode v-model="newValue" @add="append"/>

  </div>



</template>

<script>

import IllnessHistory from '../IllnessHistory.vue';

export default {
  name: 'IllnessHistoryManager',
  components: {
    IllnessHistory
  },
  props: {
      value: Object,
      offline: Boolean,
      editMode: Boolean
  },

  data: () => ({
    newValue: {},
    tick : true,
  }),

  async created() {

    if(!this.value) this.value = [];

  },

  methods:{
    append(value){
      this.tick = false
      this.newValue = {}
      this.values.push(value)
      
      this.$emit('input', this.value);

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
        this.$emit('input', this.value);
      }
    }    
  }
};
</script>
