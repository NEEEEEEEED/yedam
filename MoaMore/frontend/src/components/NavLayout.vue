<template>
  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/">
          <i class="bi bi-grid"></i>
          <span>Dashboard</span>
        </a>
      </li>
      <!-- End Dashboard Nav -->

      <li class="nav-item">
        <router-link class="nav-link" to="/user">회원관리</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link" to="/board">게시물/댓글관리</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link" to="/approve">승인게시물관리</router-link>
      </li>
    </ul>
  </aside>
  <!-- End Sidebar-->
</template>
<script>
export default {};
</script>
