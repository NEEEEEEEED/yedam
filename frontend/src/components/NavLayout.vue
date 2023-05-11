<template>
  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">
      <li class="nav-item">
        <a class="nav-link" href="index.html">
          <i class="bi bi-grid"></i>
          <span>Dashboard</span>
        </a>
      </li>
      <!-- End Dashboard Nav -->

      <li class="nav-item">
        <router-link class="nav-link" to="/user">일반회원관리</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link" to="/board">게시글관리</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link" to="/">고객센터관리</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link" to="/">매출관리</router-link>
      </li>
    </ul>
  </aside>
  <!-- End Sidebar-->
</template>
<script>
export default {};
</script>
