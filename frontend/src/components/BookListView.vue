<template>
    <v-data-table
        :headers="headers"
        :items="items"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>
</template>

<script>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { VDataTable } from 'vuetify/labs/VDataTable'

export default {
    name: 'BookListView',
    components: {
        VDataTable,
    },
    props: {
        value: Object,
        editMode: Boolean,
        isNew: Boolean
    },
    setup() {
        const headers = ref([
            // 필드 디스크립터를 기반으로 헤더 설정
            { title: "bookId", key: "bookId" },
            { title: "authorId", key: "authorId" },
            { title: "registrationDate", key: "registrationDate" },
            { title: "publicationDate", key: "publicationDate" },
            { title: "numberOfSubscribers", key: "numberOfSubscribers" },
            { title: "publicationId", key: "publicationId" },
            { title: "manuscriptId", key: "manuscriptId" },
            { title: "title", key: "title" },
            { title: "content", key: "content" },
            { title: "genre", key: "genre" },
            { title: "summary", key: "summary" },
            { title: "coverUrl", key: "coverUrl" },
            { title: "authorName", key: "authorName" },
            { title: "readCost", key: "readCost" },
            { title: "authorNickname", key: "authorNickname" },
        ]);

        const items = ref([]);

        onMounted(async () => {
            try {
                const response = await axios.get('/bookLists');
                const data = response.data._embedded.bookLists;
                data.forEach(obj => {
                    obj.id = obj._links.self.href.split("/").pop();
                });
                items.value = data;
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        });

        return {
            headers,
            items
        };
    }
}
</script>
