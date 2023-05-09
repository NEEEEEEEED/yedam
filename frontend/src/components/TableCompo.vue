<template>
  <section class="section">
    <div class="pagetitle">
      <h1>Form Layouts</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">Forms</li>
          <li class="breadcrumb-item active">Layouts</li>
        </ol>
      </nav>
    </div>

    <div class="row">
      <div class="col-lg-12">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Horizontal Form</h5>

            <!-- Horizontal Form -->
            <form>
              <div class="row mb-3">
                <label for="inputEmail3" class="col-sm-2 col-form-label"
                  >Your Name</label
                >
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputText" />
                </div>
              </div>
              <div class="row mb-3">
                <label for="inputEmail3" class="col-sm-2 col-form-label"
                  >Email</label
                >
                <div class="col-sm-10">
                  <input type="email" class="form-control" id="inputEmail" />
                </div>
              </div>
              <div class="row mb-3">
                <label for="inputPassword3" class="col-sm-2 col-form-label"
                  >Password</label
                >
                <div class="col-sm-10">
                  <input
                    type="password"
                    class="form-control"
                    id="inputPassword"
                  />
                </div>
              </div>
              <fieldset class="row mb-3">
                <legend class="col-form-label col-sm-2 pt-0">Radios</legend>
                <div class="col-sm-10">
                  <div class="form-check">
                    <input
                      class="form-check-input"
                      type="radio"
                      name="gridRadios"
                      id="gridRadios1"
                      value="option1"
                      checked=""
                    />
                    <label class="form-check-label" for="gridRadios1">
                      First radio
                    </label>
                  </div>
                  <div class="form-check">
                    <input
                      class="form-check-input"
                      type="radio"
                      name="gridRadios"
                      id="gridRadios2"
                      value="option2"
                    />
                    <label class="form-check-label" for="gridRadios2">
                      Second radio
                    </label>
                  </div>
                  <div class="form-check disabled">
                    <input
                      class="form-check-input"
                      type="radio"
                      name="gridRadios"
                      id="gridRadios3"
                      value="option3"
                      disabled=""
                    />
                    <label class="form-check-label" for="gridRadios3">
                      Third disabled radio
                    </label>
                  </div>
                </div>
              </fieldset>
              <div class="row mb-3">
                <div class="col-sm-10 offset-sm-2">
                  <div class="form-check">
                    <input
                      class="form-check-input"
                      type="checkbox"
                      id="gridCheck1"
                    />
                    <label class="form-check-label" for="gridCheck1">
                      Example checkbox
                    </label>
                  </div>
                </div>
              </div>
              <div class="text-center">
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="reset" class="btn btn-secondary">Reset</button>
              </div>
            </form>
            <!-- End Horizontal Form -->
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-md-7 grid-margin stretch-card">
        <div class="card" style="min-height: 520px">
          <div class="card-body">
            <p class="card-title">유저목록</p>
            <DataTable
              :value="userList"
              selectionMode="single"
              dataKey="id"
              showGridlines
              removableSort
              sortField="joinDt"
              paginator
              :rows="10"
              :rowsPerPageOptions="[5, 10, 20]"
              tableStyle="min-width: 100%"
              v-model="selected"
              v-on:row-select="onRowSelect"
            >
              <Column field="clsf" sortable header="분류"></Column>
              <Column field="id" sortable header="아이디"></Column>
              <Column field="name" sortable header="이름"></Column>
              <Column field="gen" sortable header="성별"></Column>
              <Column field="email" sortable header="이메일"></Column>
              <Column field="phCl" sortable header="전화번호"></Column>
              <Column field="joinDt" sortable header="가입일자"></Column>
            </DataTable>
          </div>
        </div>
      </div>
      <div class="col-md-5 grid-margin stretch-card">
        <div class="card" style="min-height: 520px">
          <div class="card-body">
            <p class="card-title">상세정보</p>
            <form class="row g-3">
              <div class="col-md-6">
                <label class="form-label">분류</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.clsf"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">이름</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.name"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">성별</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.gen"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">생년월일</label>
                <input
                  type="date"
                  class="form-control"
                  v-model="userDetail.birth"
                  readonly
                />
              </div>
              <div class="col-12">
                <label class="form-label">주소</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.addr"
                  readonly
                />
              </div>
              <div class="col-6">
                <label class="form-label">이메일</label>
                <input
                  type="email"
                  class="form-control"
                  v-model="userDetail.email"
                  readonly
                />
              </div>
              <div class="col-6">
                <label class="form-label">블로그</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.blog"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">가입일자</label>
                <input
                  type="email"
                  class="form-control"
                  v-model="userDetail.joinDt"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">최근로그인</label>
                <input
                  type="password"
                  class="form-control"
                  v-model="userDetail.ltstTm"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">전화번호</label>
                <input
                  type="email"
                  class="form-control"
                  v-model="userDetail.ph"
                  readonly
                />
              </div>
              <div class="col-md-6">
                <label class="form-label">핸드폰</label>
                <input
                  type="text"
                  class="form-control"
                  v-model="userDetail.phCl"
                  readonly
                />
              </div>
              <div class="col-12">
                <button type="button" class="btn btn-primary">Sign in</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import { userList } from "@/service/userList";
import DataTable from "primevue/datatable";
import Column from "primevue/column";
import axios from "axios";
export default {
  components: {
    DataTable,
    Column,
  },
  data() {
    return {
      userList: null,
      selected: null,
      userDetail: {
        clsf: "",
        name: "",
        gen: "",
        birth: "",
        phCl: "",
        ph: "",
        ltstTm: "",
        joinDt: "",
        blog: "",
        email: "",
        addr: "",
      },
    };
  },
  mounted() {
    userList.getUserData().then((data) => (this.userList = data));
  },
  methods: {
    onRowSelect(event) {
      const selectedRow = event.data;
      this.selected = selectedRow;
      axios
        .post("/api/getUserDetail", selectedRow, {
          withCredentials: true,
        })
        .then((response) => {
          console.log(response.data);
          this.userDetail = response.data;
        });
    },
  },
};
</script>
