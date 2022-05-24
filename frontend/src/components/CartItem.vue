
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
        CartItem # {{value._links.self.href.split("/")[value._links.self.href.split("/").length - 1]}}
    </v-card-title >
    <v-card-title v-else>
        CartItem
    </v-card-title >

    <v-card-text style = "margin-left:-15px; margin-top:10px;">

          <div>
            <Customer v-for="(val, index) in value.customers" v-model="value.customer[index]" 
            :editMode="false" v-bind:key="index" :inCard="true"/>
          </div>


          <div>
            <Payment label:=Payment v-model="value.payment" :editMode="editMode"/>
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
        @click="customer"
        v-if="!editMode"
      >
        Customer
      </v-btn>

      <v-btn
        color="deep-purple lighten-2"
        text
        @click="showCustomer"
        v-if="!editMode"
      >
        Show Customer
      </v-btn>
      
    </v-card-actions>
  </v-card>


</template>

<script>
  const axios = require('axios').default;
  
  import Customer from './Customer.vue
  
  
  import Payment from './vo/Payment.vue'
  
  export default {
    name: 'CartItem',
    components:{
      Customer,
      Payment,
    },
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        date: new Date().toISOString().substr(0, 10),
        customer : [],
        selectedCustomer : [],
        customerBtn : false,
        customerShowBtn : false,
    }),
    created(){
      if(typeof this.value.payment === 'undefined'){
        this.value.payment = {}
      }
    },

    methods: {
      edit(){
        this.editMode = true;
      },
      async save(){
        try{
          var temp = null;
          this.value.customer = this.selectedCustomer
          if(this.isNew){
            temp = await axios.post(axios.fixUrl('/cartItems'), this.value)
          }else{
            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
          }

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
          await axios.delete(axios.fixUrl(this.value._links.self.href))
          this.editMode = false;
          this.isDeleted = true;

          this.$emit('input', this.value);
          this.$emit('delete', this.value);

        }catch(e){
          alert(e.message)
        }
      },
    },
    async customer(){
      if(!this.customerBtn){
        var temp = await axios.get(axios.fixUrl('/customers'))
        this.customer = temp.data._embedded.customers
        
      }
      this.customerBtn = !this.customerBtn
    },
    async show(){
        
        if(!this.customerShowBtn){
          var temp = await axios.get(axios.fixUrl(this.value._links.customer.href));
          this.value.customer = temp.data._embedded.customers
          
        }
        this.customerShowBtn = !this.customerShowBtn
      }
  }
</script>

