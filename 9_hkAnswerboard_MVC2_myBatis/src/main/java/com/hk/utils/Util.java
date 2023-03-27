package com.hk.utils;

public class Util {

	// <jsp:setPropery /> : set메서드 실행
	// <jsp:getPropery /> : get메서드 실행
	
	private String arrow;

	public void setArrow(String depth) {
		String nbsp="";
		int depthInt=Integer.parseInt(depth);
		for (int i = 0; i < depthInt; i++) {
			nbsp+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		this.arrow =nbsp+(depthInt>0?"<img style='width:10px;height:10px;' src='img/arrow.png'/>":"");
		//최상위부모는 답글이 아니라서 화살표가 출력되면 안됨 : depthInt>0
	}

	public String getArrow() {
		return arrow;
	}
}
