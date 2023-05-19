<template>
  <Button
    type="button"
    label="Cancel"
    icon="pi pi-times"
    @click="closeDialog({ buttonType: 'No' })"
    text
  ></Button>
  <Button
    type="button"
    label="Save"
    icon="pi pi-check"
    @click="closeDialog({ buttonType: 'Yes' })"
    autofocus
  ></Button>
</template>

<script>
import Button from "primevue/button";

export default {
  components: {
    Button,
  },
  inject: ["dialogRef"],
  methods: {
    closeDialog(e) {
      this.dialogRef.close(e);
    },
  },
};
</script>
