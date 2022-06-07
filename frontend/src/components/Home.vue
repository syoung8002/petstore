<template>
    
    <v-container>
        <v-row>

       <v-col
            cols="4"
          >

              <v-card
    class="mx-auto"
    max-width="344"
  >
    <v-img
      src="data:image/jpeg;base64,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"
      height="200px"
    ></v-img>

    <v-card-title>
        Pet Management
    </v-card-title>

    <v-card-subtitle>
      pet management bounded context supports pet management including pet grooming and pet feeding.
    </v-card-subtitle>

    <v-card-actions>
      <v-btn
        color="orange lighten-2"
        text
      >
        Explore
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn
        icon
        @click="show = !show"
      >
        <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
      </v-btn>
    </v-card-actions>

  </v-card>

 
          </v-col>
          <v-col
            cols="4"
          >

              <v-card
    class="mx-auto"
    max-width="344"
  >
    <v-img
      src="https://img.etimg.com/thumb/width-1200,height-900,imgsize-122620,resizemode-1,msid-75214721/industry/services/retail/future-group-negotiates-rents-for-its-1700-stores.jpg"
      height="200px"
    ></v-img>

    <v-card-title>
        Pet Store
    </v-card-title>

    <v-card-subtitle>
        Pet Store bounded context supports item management including item adoption and item dissolution.
    </v-card-subtitle>

    <v-card-actions>
      <v-btn
        color="orange lighten-2"
        text
      >
        Explore
      </v-btn>

      <v-spacer></v-spacer>

      <v-btn
        icon
        @click="show = !show"
      >
        <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
      </v-btn>
    </v-card-actions>

    <v-expand-transition>
      <div v-show="show">
        <v-divider></v-divider>

        <v-card-text>
          I'm a thing. But, like most politicians, he promised more than he could deliver. You won't have time for sleeping, soldier, not with all the bed making you'll be doing. Then we'll go with that data file! Hey, you add a one and two zeros to that or we walk! You're going to do his laundry? I've got to find a way to escape.
        </v-card-text>
      </div>
    </v-expand-transition>
  </v-card>

 
          </v-col>

   
        </v-row>
      </v-container>



</template>

<script>
export default {
    name: "Home",

};
</script>
<style>
</style>
