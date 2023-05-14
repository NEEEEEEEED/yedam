<template>
  <div
    class="modal fade show modal-bg"
    tabindex="-1"
    style="display: block"
    aria-modal="true"
    role="dialog"
  >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Large Modal</h5>
          <button type="button" class="btn-close" @click="close"></button>
        </div>
        <div class="modal-body">
          Non omnis incidunt qui sed occaecati magni asperiores est mollitia.
          Soluta at et reprehenderit. Placeat autem numquam et fuga numquam.
          Tempora in facere consequatur sit dolor ipsum. Consequatur nemo amet
          incidunt est facilis. Dolorem neque recusandae quo sit molestias sint
          dignissimos.
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary">Save changes</button>
          <button type="button" class="btn btn-secondary" @click="close">
            Close
          </button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "cntnModal",
  props: {
    cntnToggle: {
      type: Number,
      required: true,
    },
  },
  methods: {
    close() {
      console.log("모달 닫기");
      this.$emit("update:cntnToggle", 0);
    },
  },
};
</script>
<style>
.modal-bg {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* 배경색을 설정합니다. */
  z-index: 1000; /* 모달창 보다 낮은 z-index 값을 설정합니다. */
}
.modal {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 1001; /* 모달창보다 높은 z-index 값을 설정합니다. */
}
</style>
