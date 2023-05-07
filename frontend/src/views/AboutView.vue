<template>
  <div class="about">
    <h1>This is an about page 수정</h1>
    <li class="nav-item mt-2 mt-lg-0">
      <a
        sec:authorize="isAnonymous()"
        class="nav-link btn btn-light text-black w-md-25 w-50 w-lg-100"
        aria-current="page"
        href="/login"
        >로그인 / 회원가입</a
      >
    </li>
    <li class="nav-item mt-2 mt-lg-0">
      <a
        sec:authorize="isAuthenticated()"
        class="nav-link btn btn-light text-black w-md-25 w-50 w-lg-100"
        aria-current="page"
        href="/logout"
        >로그아웃</a
      >
    </li>
  </div>
</template>
