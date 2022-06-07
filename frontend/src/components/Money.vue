<template>

<v-card style="width:300px; margin-left:5%;" outlined>
    <v-card-title>
        {{label}}
    </v-card-title>

    <v-card-text style = "margin-left:-15px; margin-top:10px;">

          <div>
            <Double :offline="offline" label="Amount" v-model="value.amount" :editMode="editMode" @input="change" @change="change"/>
          </div>

          

          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field label="Currency" v-model="value.currency" @change="change"/>
          </div>
          <div class="grey--text ml-4" v-else>
            Currency :  {{value.currency }}
          </div>

          <div>
            <String :offline="offline" label="Currency" v-model="value.currency" :editMode="editMode"/>
          </div>


    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-actions style = "position:absolute; right:0; bottom:0;" v-if="inList">
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
        @click="add"
        v-else
      >
        Add
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="remove"
        v-if="!editMode"
      >
        Delete
      </v-btn>

    </v-card-actions>
  </v-card>


</template>

<script>
  
  import Double from './primitives/Double.vue'

  export default {
    name: 'Money',
    components:{
      Double
    },
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean,
      offline: Boolean,
      inList: Boolean,
      label: String
    },
    data: () => ({
        date: new Date().toISOString().substr(0, 10),
    }),
    created(){

      if(!this.value) this.value = {};

    },

    methods: {
      edit(){
        this.editMode = true;
      },
      async add(){
          this.editMode = false;
          this.$emit('input', this.value);

          if(this.isNew){
            this.$emit('add', this.value);
          }else{
            this.$emit('edit', this.value);
          }
      },
      async remove(){
          this.editMode = false;
          this.isDeleted = true;

          this.$emit('input', this.value);
          this.$emit('delete', this.value);
      },
      change(){
        this.$emit('input', this.value);
      }
    }
  }
</script>

