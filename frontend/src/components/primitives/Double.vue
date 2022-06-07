
<template>
          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field type="number" :label="label" v-model="value" @change="change"/>
          </div>
          <div class="grey--text ml-4" v-else>
            {{label}} :  {{value }}
          </div>
</template>

<script>
  
  export default {
    name: 'Double',
    components:{
    },
    props: {
      value: Object,
      editMode: Boolean,
      label: String
    },
    methods:{
        change(){
            this.$emit("input", this.value);
        }
    }
  }
</script>