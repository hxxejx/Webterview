<template>
<div class="limiter">
    <div class="container-login100 shadow-lg">
      <div class="wrap-login100" style="margin-left: 20%; margin-right: 5%;">
            <div class="head mb-4">면접관 상세정보</div>
            <div class="d-flex flex-column justify-content-center align-items-between mt-2">
                <div class="d-flex justify-content-center align-items-between">
                    <div class="container  mx-2"> 
                        <div> 
                            
                            <div class="" style="overflow: auto; height: 55vh; width: 80vh;">
                                <div class="profile">
                                    <!-- <h3 style="background-color: #30475e; color: #fff" >지원자 정보</h3> -->
                                    <table class="table white-bg">
            
                                    <tbody>
                                        <tr>
                                        <th scope="row">이름:</th>
                                        <td colspan="3">{{ rater.raterName }}</td>
                                        </tr>
                                        <tr>
                                        <th scope="row">이메일:</th>
                                        <td colspan="3">{{ rater.raterEmail }}</td>
                                        </tr>
                                        <tr>
                                        <th scope="row">전화:</th>
                                        <td colspan="3">{{ rater.raterPhone}}</td>
                                        </tr>
                                        <!-- <tr>
                                        <th scope="row">면접자 번호:</th>
                                        <td colspan="3">{{ rater.raterNo}}</td>
                                        </tr> -->
                                        <tr>
                                        <th scope="row">배정 방번호:</th>
                                        <td colspan="3">
                                            <input class="rater-roomNo" type="text" v-model="credentials.roomIdx"><button type="button" class="adit-btn" @click="modifyRater(credentials)">수정</button>
                                        </td>
                                        </tr>
                                    </tbody>
                                    </table>
                                </div>
                                <!-- {{ credentials }} -->
                                <!-- <div>
                                    <form @submit.prevent="modifyRater(credentials)">
                                        <label for="roomNo" class="roomNo-label">면접장 번호: </label>
                                        <input class="rater-roomNo" type="text" v-model="credentials.roomNo">
                                        <button type="submit" class="adit-btn">수정</button>
                                    </form>
                                </div> -->
                                <!-- <button class="deleteRaterBtn" type="button" @click="removeRater(rater.raterNo)">면접관 삭제</button> -->
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
      </div>
    </div>
</div>
  
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
    name: 'RaterDetailView',
    data() {
      return {
        raterNo: this.$route.params.raterNo,
        roomNo: this.$route.params.roomNo,
        roomIdx: this.$route.params.roomIdx,
        credentials: {
            raterNo: this.$route.params.raterNo,
            roomIdx: this.$route.params.roomIdx,
            groupNo: this.groupNo,
        }
      }
    },
    computed: {
      ...mapGetters(['rater','groupNo'])
    },
    methods: {
      ...mapActions(['fetchRater', 'updateRaters','removeRater', 'modifyRater']),
      
      
    },
    async created() {
        console.log(this.raterNo)
        await this.fetchRater(this.raterNo)
        console.log(this.rater.roomIdx)
        this.credentials.raterNo = this.rater.raterNo
        this.credentials.roomIdx = this.rater.roomIdx
        this.credentials.groupNo = this.rater.groupNo
        // this.credentials.roomIdx = this.rater.roomIdx
    },
    mounted(){
        this.fetchRater(this.raterNo)
        // console.log(this.rater.roomIdx)
        this.credentials.raterNo = this.rater.raterNo
        this.credentials.roomIdx = this.rater.roomIdx
        this.credentials.groupNo = this.rater.groupNo
    }
    
}
</script>

<style scoped>
    .btn {
        background-color: #30475e;
        color: white;
    }

    .container {
        background-color: #fff;
        padding: 1px;
    }

    .filebox .upload-name {
        display: inline-block;
        vertical-align: middle;
        border: 1px solid #dddddd;
        width: 60%;
        color: #999999;
    }

    .detail {
        background-color: #c4d4e3;
        height: 65vh;
    }

    .deleteFile {
        background-color: crimson;
        border-block-color: crimson;
    }

    .deleteRaterBtn{
        /* position: relative;
        left: 40%; */
        border: none;
        padding: 8px 16px;
        border-radius: 15px;
        font-family: "paybooc-Light", sans-serif;
        box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
        text-decoration: none;
        font-weight: 600;
        transition: 0.25s;
        background-color: #f05454;
        color: #fff;
    }
    .deleteRaterBtn:hover {
        background-color: #f38181;
        color: #fff;
    }

    .rater-roomNo {
        background-color: rgb(226, 221, 221);
        text-align: center;
        border-radius: 15px;
        /* justify-content: center; */
    }

    .roomNo-label {
        position: relative;
        right:10%;
    }

    .adit-btn {
        position: relative;
        left: 10%;
        border: none;
        padding: 4px 8px;
        border-radius: 10px;
        font-family: "paybooc-Light", sans-serif;
        box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
        text-decoration: none;
        font-weight: 600;
        transition: 0.25s;
        background-color: #30475e;
        color: #fff;
        font-size: 12px;
    }
    .adit-btn:hover {
        background-color: #55799c;
        color: #fff;
    }
</style>