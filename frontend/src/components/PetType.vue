<template>

        <v-select v-model="value" @change="change"
          :items="items"
          :label="label"
        ></v-select>


</template>

<script>
  
  export default {
    name: 'PetType',
    props: {
      label: String,
      value: Object,
      editMode: Boolean
    },
    data: () => ({
        items: ['CAT', 'DOG']
    }),
    created(){
    },

    methods:{

        change(){
            this.$emit('input', this.value);
        }

    }

  }
</script>

