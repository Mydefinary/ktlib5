<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '작가관리' }" />
        <VerticalNavLink
            :item="{
                title: '작가',
                to: '/authors',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 목록',
                to: '/authorLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '원고집필 관리' }" />
        <VerticalNavLink
            :item="{
                title: '원고',
                to: '/manuscripts',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '원고목록',
                to: '/manuscriptLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '출간 관리' }" />
        <VerticalNavLink
            :item="{
                title: '출간',
                to: '/publishes',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '책관리' }" />
        <VerticalNavLink
            :item="{
                title: '책',
                to: '/books',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '책 목록',
                to: '/bookLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '포인트관리' }" />
        <VerticalNavLink
            :item="{
                title: '포인트',
                to: '/points',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트목록',
                to: '/pointsLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '사용자관리' }" />
        <VerticalNavLink
            :item="{
                title: '사용자',
                to: '/users',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '구독관리' }" />
        <VerticalNavLink
            :item="{
                title: '책 구독',
                to: '/subscribeSus',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독목록',
                to: '/subscribeLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '정기 구독 관리' }" />
        <VerticalNavLink
            :item="{
                title: '정기구독',
                to: '/periodSubscribes',
            }"
        />
    </ul>
</template>
