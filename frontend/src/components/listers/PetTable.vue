<template>

<v-data-table
    :headers="headers"
    :items="pet"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'Pet',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "energy", value: "energy" },
            { text: "appearance", value: "appearance" },
            { text: "name", value: "name" },
            { text: "placeOfBirth", value: "placeOfBirth" },
            { text: "state", value: "state" },
            { text: "petType", value: "petType" },
            { text: "illnessHistory", value: "illnessHistory" },
        ],
        pet : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/pets')

      this.pet = temp.data._embedded.pets;

    },
    methods: {
    }
  }
</script>

