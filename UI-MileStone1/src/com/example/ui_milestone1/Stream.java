/**
 * 
 */
package com.example.ui_milestone1;

/**
 * @author jiqbal
 *
 */
public class Stream {

	private String Videoid;
	private float Duration;
	private float OverAllBitRate;
	private float VideoBitRate;
	private float Width;
	private float Height;
	private float ExpectedBitRate;
	private float FPS;
	private String Codec;
	private String Catagory;
	private String Url;
	private int Popularity;
	/**
	 * @param videoid
	 * @param duration
	 * @param bitRateOverall
	 * @param videobitRate
	 * @param width
	 * @param height
	 * @param totalBitRate
	 * @param fps
	 * @param codec
	 * @param catagory
	 * @param url
	 */
	public Stream(String videoid, float duration, float bitRateOverall,
			float videobitRate, float width, float height, float expectedBitRate, float fps,
			String codec, String catagory, String url, int Popularity) {
		super();
		this.Videoid = videoid;
		this.Duration = duration;
		this.OverAllBitRate = bitRateOverall;
		this.VideoBitRate = videobitRate;
		this.Width = width;
		this.Height = height;
		this.ExpectedBitRate = expectedBitRate;
		this.FPS = fps;
		this.Codec = codec;
		this.Catagory = catagory;
		this.Url = url;
		this.Popularity = Popularity;
	}
	public Stream () {
		
		super();
		this.Videoid = "";
		this.Duration = 0;
		this.OverAllBitRate = 0;
		this.VideoBitRate = 0;
		this.Width = 0;
		this.Height = 0;
		this.ExpectedBitRate = 0;
		this.FPS = 0;
		this.Codec = "";
		this.Catagory = "";
		this.Url = "http://";
		this.Popularity = 0;
		
	}
	/**
	 * @return the videoid
	 */
	public String getVideoid() {
		return Videoid;
	}
	/**
	 * @param videoid the videoid to set
	 */
	public void setVideoid(String videoid) {
		Videoid = videoid;
	}
	/**
	 * @return the duration
	 */
	public float getDuration() {
		return Duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(float duration) {
		Duration = duration;
	}
	/**
	 * @return the overAllBitRate
	 */
	public float getOverAllBitRate() {
		return OverAllBitRate;
	}
	/**
	 * @param overAllBitRate the overAllBitRate to set
	 */
	public void setOverAllBitRate(float overAllBitRate) {
		OverAllBitRate = overAllBitRate;
	}
	/**
	 * @return the videoBitRate
	 */
	public float getVideoBitRate() {
		return VideoBitRate;
	}
	/**
	 * @param videoBitRate the videoBitRate to set
	 */
	public void setVideoBitRate(float videoBitRate) {
		VideoBitRate = videoBitRate;
	}
	/**
	 * @return the width
	 */
	public float getWidth() {
		return Width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(float width) {
		Width = width;
	}
	/**
	 * @return the height
	 */
	public float getHeight() {
		return Height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(float height) {
		Height = height;
	}
	/**
	 * @return the expectedBitRate
	 */
	public float getExpectedBitRate() {
		return ExpectedBitRate;
	}
	/**
	 * @param expectedBitRate the expectedBitRate to set
	 */
	public void setExpectedBitRate(float expectedBitRate) {
		ExpectedBitRate = expectedBitRate;
	}
	/**
	 * @return the fPS
	 */
	public float getFPS() {
		return FPS;
	}
	/**
	 * @param fPS the fPS to set
	 */
	public void setFPS(float fPS) {
		FPS = fPS;
	}
	/**
	 * @return the codec
	 */
	public String getCodec() {
		return Codec;
	}
	/**
	 * @param codec the codec to set
	 */
	public void setCodec(String codec) {
		Codec = codec;
	}
	/**
	 * @return the catagory
	 */
	public String getCatagory() {
		return Catagory;
	}
	/**
	 * @param catagory the catagory to set
	 */
	public void setCatagory(String catagory) {
		Catagory = catagory;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return Url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		Url = url;
	}
	/**
	 * @return the popularity
	 */
	public int getPopularity() {
		return Popularity;
	}
	/**
	 * @param popularity the popularity to set
	 */
	public void setPopularity(int popularity) {
		Popularity = popularity;
	}
	
	


}
