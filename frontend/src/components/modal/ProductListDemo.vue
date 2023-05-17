<template>
  <div>
    <DataTable :value="products">
      <Column field="code" header="Code"></Column>
      <Column field="name" header="Name"></Column>
      <Column header="Image">
        <template #body="slotProps">
          <img
            :src="
              'https://primefaces.org/cdn/primevue/images/product/' +
              slotProps.data.image
            "
            :alt="slotProps.data.name"
            class="shadow-2 w-4rem"
          />
        </template>
      </Column>
      <Column field="category" header="Category"></Column>
      <Column field="quantity" header="Quantity"></Column>
      <Column style="width: 5rem">
        <template #body="slotProps">
          <Button
            type="button"
            icon="pi pi-plus"
            text
            rounded
            @click="selectProduct(slotProps.data)"
          ></Button>
        </template>
      </Column>
    </DataTable>
  </div>
</template>

<script>
import { ProductService } from "@/service/ProductService";
import InfoDemo from "./InfoDemo.vue";
import Button from "primevue/button";
import DataTable from "primevue/datatable";
import Column from "primevue/column";

export default {
  inject: ["dialogRef"],
  components: {
    Button,
    DataTable,
    Column,
  },
  data() {
    return {
      products: null,
    };
  },
  mounted() {
    ProductService.getProductsSmall().then(
      (data) => (this.products = data.slice(0, 5))
    );
  },
  methods: {
    selectProduct(data) {
      this.dialogRef.close(data);
    },
    showInfo() {
      this.$dialog.open(InfoDemo, {
        props: {
          header: "Information",
          modal: true,
          dismissableMask: true,
        },
        data: {
          totalProducts: this.products ? this.products.length : 0,
        },
      });
    },
  },
};
</script>
