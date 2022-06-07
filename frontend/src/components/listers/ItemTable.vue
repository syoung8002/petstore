<template>

<v-data-table
    :headers="headers"
    :items="item"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'Item',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "pet", value: "pet" },
            { text: "price", value: "price" },
        ],
        item : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/items')

      this.item = temp.data._embedded.items;

    },
    methods: {
    }
  }
</script>

