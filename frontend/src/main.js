import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store/storage";
import PrimeVue from "primevue/config";
import DataTable from "primevue/datatable";
import Column from "primevue/column";
import ColumnGroup from "primevue/columngroup";
import Row from "primevue/row";
import ToastService from "primevue/toastservice";
import ConfirmationService from "primevue/confirmationservice";

//core
import "primevue/resources/primevue.min.css";
//theme
import "primevue/resources/themes/lara-light-indigo/theme.css";

createApp(App)
  .use(router)
  .use(store)
  .use(PrimeVue)
  .use(DataTable)
  .use(Column)
  .use(ColumnGroup)
  .use(Row)
  .use(ToastService)
  .use(ConfirmationService)
  .mount("#app");
