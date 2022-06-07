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
        Pet # {{value._links.self.href.split("/")[value._links.self.href.split("/").length - 1]}}
    </v-card-title >
    <v-card-title v-else>
        Pet
    </v-card-title >

    <v-card-text style = "margin-left:-15px; margin-top:10px;">

          <div>
            <PetType label="petType" v-model="value.petType" :editMode="editMode"/>
          </div>


          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field type="number" label="Energy" v-model="value.energy"/>
          </div>
          <div class="grey--text ml-4" v-else>
            Energy :  {{value.energy }}
          </div>

          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field type="number" label="Appearance" v-model="value.appearance"/>
          </div>
          <div class="grey--text ml-4" v-else>
            Appearance :  {{value.appearance }}
          </div>

          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field label="Name" v-model="value.name"/>
          </div>
          <div class="grey--text ml-4" v-else>
            Name :  {{value.name }}
          </div>

          <div>
            <Address label="PlaceOfBirth" v-model="value.placeOfBirth" :editMode="editMode"/>
          </div>

          <div>
            <IllnessHistoryList offline label="IllnessHistory" v-model="value.illnessHistory" :editMode="editMode"/>
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
        @click="feed"
        v-if="!editMode"
      >
        Feed
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="groom"
        v-if="!editMode"
      >
        Groom
      </v-btn>
    </v-card-actions>
  </v-card>


</template>

<script>
  const axios = require('axios').default;
  
  
  
  
  import Address from './vo/Address.vue'
  import IllnessHistoryList from './listers/IllnessHistoryChips.vue'
  
  
  
  export default {
    name: 'Pet',
    components:{
      Address,IllnessHistoryList
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
      if(typeof this.value.placeOfBirth === 'undefined'){
        this.value.placeOfBirth = {}
      }
    },

    methods: {
      edit(){
        this.editMode = true;
      },
      async save(){
        try{
          var temp = null;

          if(!this.offline){
            if(this.isNew){
              temp = await axios.post(axios.fixUrl('/pets'), this.value)
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
      async feed(){
        try{
          if(!this.offline){
            var temp = await axios.put(axios.fixUrl(this.value._links.feed.href))
            for(var k in temp.data) this.value[k]=temp.data[k];
          }

          this.editMode = false;
        }catch(e){
          alert(e.message)
        }
      },
      
      async groom(){
        try{
          if(!this.offline){
            var temp = await axios.put(axios.fixUrl(this.value._links.groom.href))
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

