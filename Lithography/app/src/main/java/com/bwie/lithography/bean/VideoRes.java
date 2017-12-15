package com.bwie.lithography.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dell on 2017/12/15.
 */

public class VideoRes implements Serializable{

    /**
     * msg : 成功
     * ret : {"pnum":1,"totalRecords":12,"records":20,"list":[{"msg":"这是讲一个失足少女被老男人抛弃最后找到真爱的故事\u2026\u2026","phoneNumber":"18481206706","dataId":"ff8080815ec76df0015efc8ae0fe16c3","userPic":"","time":"2017-10-08 23:11:53","likeNum":2},{"msg":"不错","phoneNumber":"一个转身的距离","dataId":"ff8080815e2875fb015e2bcf7a1705a1","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/08/25/1503638016999349222.jpg","time":"2017-08-29 10:26:11","likeNum":4},{"msg":"挺有意思的","phoneNumber":"Misfit","dataId":"ff8080815de4a948015de6b41a953442","userPic":"http://q.qlogo.cn/qqapp/1101034181/B6C4147F840D21389FB41E23EA66F9E3/40","time":"2017-08-16 00:22:29","likeNum":3},{"msg":"一般般","phoneNumber":"136****6961","dataId":"ff8080815dcb455e015dcc29f4f41b31","userPic":"","time":"2017-08-10 20:41:28","likeNum":3},{"msg":"额 无话可说","phoneNumber":"心心公主","dataId":"ff8080815db0e26f015db5f4c86d76dd","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/04/23/1492938863835364652.jpg","time":"2017-08-06 13:11:44","likeNum":2},{"msg":"怎么样搜索才有用","phoneNumber":"136****8356","dataId":"ff8080815d078b01015d36f4d26f4609","userPic":"","time":"2017-07-12 21:20:00","likeNum":2},{"msg":"有味，不错，低调而不低俗，有欢笑，更有亮点!赞一个!","phoneNumber":"0","dataId":"ff8080815d078bbc015d1e187c2f3cb3","userPic":"http://q.qlogo.cn/qqapp/1101034181/B456EB39D6B5EC785C333C2603CE9F25/40","time":"2017-07-08 01:28:27","likeNum":1},{"msg":"什么鬼啊，超哥脑洞太大！！！表示不懂","phoneNumber":"用户6277768524","dataId":"ff8080815ceda003015d064627ad71f4","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/07/01/1498914836877230582.jpg","time":"2017-07-03 10:27:27","likeNum":2},{"msg":"这部片子得抽空再看一遍才行，拍的挺好的。","phoneNumber":"忧别人之忧","dataId":"ff8080815ceda201015cf8ab898e01f0","userPic":"","time":"2017-06-20 20:03:30","likeNum":15},{"msg":"没想到这个电影在手机电影APP里居然可以看到，赞一个。","phoneNumber":"给你快乐","dataId":"ff8080815ceda201015cf8ab899201f2","userPic":"","time":"2017-06-18 19:03:30","likeNum":17},{"msg":"电影一般般吧，唯一的亮点是女主。","phoneNumber":"自欺欺人","dataId":"ff8080815ceda201015cf8ab898901ef","userPic":"","time":"2017-06-12 23:03:30","likeNum":10},{"msg":"谁能给我介绍几部跟这个电影同类型的影片？","phoneNumber":"陌路丢了谁","dataId":"ff8080815ceda201015cf8ab899001f1","userPic":"","time":"2017-05-26 19:56:30","likeNum":3}],"totalPnum":1}
     * code : 200
     */

    private String msg;
    private RetBean ret;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RetBean getRet() {
        return ret;
    }

    public void setRet(RetBean ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class RetBean implements Serializable{
        /**
         * pnum : 1
         * totalRecords : 12
         * records : 20
         * list : [{"msg":"这是讲一个失足少女被老男人抛弃最后找到真爱的故事\u2026\u2026","phoneNumber":"18481206706","dataId":"ff8080815ec76df0015efc8ae0fe16c3","userPic":"","time":"2017-10-08 23:11:53","likeNum":2},{"msg":"不错","phoneNumber":"一个转身的距离","dataId":"ff8080815e2875fb015e2bcf7a1705a1","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/08/25/1503638016999349222.jpg","time":"2017-08-29 10:26:11","likeNum":4},{"msg":"挺有意思的","phoneNumber":"Misfit","dataId":"ff8080815de4a948015de6b41a953442","userPic":"http://q.qlogo.cn/qqapp/1101034181/B6C4147F840D21389FB41E23EA66F9E3/40","time":"2017-08-16 00:22:29","likeNum":3},{"msg":"一般般","phoneNumber":"136****6961","dataId":"ff8080815dcb455e015dcc29f4f41b31","userPic":"","time":"2017-08-10 20:41:28","likeNum":3},{"msg":"额 无话可说","phoneNumber":"心心公主","dataId":"ff8080815db0e26f015db5f4c86d76dd","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/04/23/1492938863835364652.jpg","time":"2017-08-06 13:11:44","likeNum":2},{"msg":"怎么样搜索才有用","phoneNumber":"136****8356","dataId":"ff8080815d078b01015d36f4d26f4609","userPic":"","time":"2017-07-12 21:20:00","likeNum":2},{"msg":"有味，不错，低调而不低俗，有欢笑，更有亮点!赞一个!","phoneNumber":"0","dataId":"ff8080815d078bbc015d1e187c2f3cb3","userPic":"http://q.qlogo.cn/qqapp/1101034181/B456EB39D6B5EC785C333C2603CE9F25/40","time":"2017-07-08 01:28:27","likeNum":1},{"msg":"什么鬼啊，超哥脑洞太大！！！表示不懂","phoneNumber":"用户6277768524","dataId":"ff8080815ceda003015d064627ad71f4","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/07/01/1498914836877230582.jpg","time":"2017-07-03 10:27:27","likeNum":2},{"msg":"这部片子得抽空再看一遍才行，拍的挺好的。","phoneNumber":"忧别人之忧","dataId":"ff8080815ceda201015cf8ab898e01f0","userPic":"","time":"2017-06-20 20:03:30","likeNum":15},{"msg":"没想到这个电影在手机电影APP里居然可以看到，赞一个。","phoneNumber":"给你快乐","dataId":"ff8080815ceda201015cf8ab899201f2","userPic":"","time":"2017-06-18 19:03:30","likeNum":17},{"msg":"电影一般般吧，唯一的亮点是女主。","phoneNumber":"自欺欺人","dataId":"ff8080815ceda201015cf8ab898901ef","userPic":"","time":"2017-06-12 23:03:30","likeNum":10},{"msg":"谁能给我介绍几部跟这个电影同类型的影片？","phoneNumber":"陌路丢了谁","dataId":"ff8080815ceda201015cf8ab899001f1","userPic":"","time":"2017-05-26 19:56:30","likeNum":3}]
         * totalPnum : 1
         */

        private int pnum;
        private int totalRecords;
        private int records;
        private int totalPnum;
        private List<ListBean> list;

        public int getPnum() {
            return pnum;
        }

        public void setPnum(int pnum) {
            this.pnum = pnum;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public int getTotalPnum() {
            return totalPnum;
        }

        public void setTotalPnum(int totalPnum) {
            this.totalPnum = totalPnum;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable{
            /**
             * msg : 这是讲一个失足少女被老男人抛弃最后找到真爱的故事……
             * phoneNumber : 18481206706
             * dataId : ff8080815ec76df0015efc8ae0fe16c3
             * userPic :
             * time : 2017-10-08 23:11:53
             * likeNum : 2
             */

            private String msg;
            private String phoneNumber;
            private String dataId;
            private String userPic;
            private String time;
            private int likeNum;

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public String getUserPic() {
                return userPic;
            }

            public void setUserPic(String userPic) {
                this.userPic = userPic;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }
        }
    }
}
