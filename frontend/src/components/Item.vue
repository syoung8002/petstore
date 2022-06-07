<template>

<v-card style="width:300px; margin-left:5%;" outlined>
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img
      style="width:290px; height:150px; border-radius:10px; position:relative; margin-left:5px; top:5px;"
      src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
    ></v-img>

    <v-card-title v-if="value._links">
        Item # {{value._links.self.href.split("/")[value._links.self.href.split("/").length - 1]}}
    </v-card-title >
    <v-card-title v-else>
        Item
    </v-card-title >

    <v-card-text style = "margin-left:-15px; margin-top:10px;">

          <div>
            <Money offline label="Price" v-model="value.price" :editMode="editMode" :key="editMode" @change="change"/>
          </div>

          <div>
            <User label="Adopter" v-model="value.adopter" :editMode="editMode"/>
          </div>

          <div>
            <Status offline label="Status" v-model="value.status" :editMode="editMode"  @change="change"/>
          </div>

          <div>
            <PetId offline label="PetId" v-model="value.petId" :editMode="editMode"  @change="change"/>
          </div>


    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-actions style = "position:absolute; right:0; bottom:0;">
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="edit"
        v-if="!editMode"
      >
        Edit
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="save"
        v-else
      >
        Save
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="remove"
        v-if="!editMode"
      >
        Delete
      </v-btn>
      
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="adopt"
        v-if="!editMode"
      >
        Adopt
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="dissolute"
        v-if="!editMode"
      >
        Dissolute
      </v-btn>
    </v-card-actions>
  </v-card>


</template>

<script>
  const axios = require('axios').default;
  
  
  import User from './vo/User.vue'
  
  
  
  export default {
    name: 'Item',
    components:{
      User,
    },
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean,
      offline: Boolean
    },
    data: () => ({
        date: new Date().toISOString().substr(0, 10),
    }),
    created(){
      if(typeof this.value.adopter === 'undefined'){
        this.value.adopter = {}
      }
    },

    methods: {
      edit(){
        this.editMode = true;
        this.$forceUpdate()
      },
      async save(){
        try{
          var temp = null;

          if(!this.offline){
            if(this.isNew){
              temp = await axios.post(axios.fixUrl('/items'), this.value)
            }else{
              temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
            }
          }

          if(this.value!=null)
            for(var k in temp.data) this.value[k]=temp.data[k];
          else 
            this.value = temp.data;

          this.editMode = false;
          this.$emit('input', this.value);

          if(this.isNew){
            this.$emit('add', this.value);
          }else{
            this.$emit('edit', this.value);
          }

        }catch(e){
          alert(e.message)
        }
      },
      async remove(){
        try{
          if(!this.offline)
            await axios.delete(axios.fixUrl(this.value._links.self.href))

          this.editMode = false;
          this.isDeleted = true;

          this.$emit('input', this.value);
          this.$emit('delete', this.value);

        }catch(e){
          alert(e.message)
        }
      },
      change(){
          this.$emit('input', this.value);
      }
      ,

      async adopt(){
        try{
          if(!this.offline){
            var temp = await axios.put(axios.fixUrl(this.value._links.adopt.href))
            for(var k in temp.data) this.value[k]=temp.data[k];
          }

          this.editMode = false;
        }catch(e){
          alert(e.message)
        }
      },
      
      async dissolute(){
        try{
          if(!this.offline){
            var temp = await axios.put(axios.fixUrl(this.value._links.dissolute.href))
            for(var k in temp.data) this.value[k]=temp.data[k];
          }

          this.editMode = false;
        }catch(e){
          alert(e.message)
        }
      },
      
    },
  }
</script>

