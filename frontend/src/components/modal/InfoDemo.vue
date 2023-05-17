<template>
  <div>
    <p>
      There are <strong>{{ totalProducts }}</strong> products in total in this
      list.
    </p>
    <div class="flex justify-content-end">
      <Button type="button" label="Close" @click="closeDialog"></Button>
    </div>
  </div>
</template>

<script>
import Button from "primevue/button";
export default {
  inject: ["dialogRef"],
  components: {
    Button,
  },
  data() {
    return {
      totalProducts: 0,
    };
  },
  mounted() {
    this.totalProducts = this.dialogRef.data.totalProducts;
  },
  methods: {
    closeDialog() {
      this.dialogRef.close();
    },
  },
};
</script>
