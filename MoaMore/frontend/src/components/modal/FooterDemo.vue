<template>
  <Button
    type="button"
    label="닫기"
    icon="pi pi-times"
    @click="closeDialog({ buttonType: 'No' })"
    text
  ></Button>
  <Button
    type="button"
    label="저장"
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
