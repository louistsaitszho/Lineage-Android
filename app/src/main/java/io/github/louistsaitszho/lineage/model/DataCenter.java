package io.github.louistsaitszho.lineage.model;

import java.util.List;

/**
 * Created by louistsai on 27.08.17.
 */
public interface DataCenter {

    /**
     * Get a list of videos
     * @return A Cancelable object so that you can cancel the request if necessary
     */
    Cancelable getVideos(String moduleId, DataListener<List<Video>> callback);

    Cancelable getModules(DataListener<List<Module>> callback);

    void setModuleToNeedsDownload(Module module, boolean needsDownload);

    /**
     * Get the school code
     * This always gets stored on the device itself, because this is how the cloud know which school
     * this phone is suppose to be at
     * @return the school code from local storage, should be nullable
     */
    Cancelable getSchoolCodeLocally(DataListener<String> callback);

    Cancelable signIn(String schoolCode, DataListener<School> callback);

    /**
     * Most implementations of data storage or fetching library requires termination of something.
     * Implement whatever you need to do so that whoever use it don't need to know exactly how to
     * close each things specifically
     */
    void close();
}
