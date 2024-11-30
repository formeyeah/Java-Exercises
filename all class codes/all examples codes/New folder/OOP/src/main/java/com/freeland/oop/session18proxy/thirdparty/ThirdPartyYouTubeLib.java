package com.freeland.oop.session18proxy.thirdparty;

import java.util.HashMap;

import com.freeland.oop.session18proxy.Video;

public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideos();
    Video getVideo(String videoId);
}
