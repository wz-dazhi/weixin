/**
 * 
 */
package com.bwie.weixin.message;

import java.util.List;

/**
 * @function 回复图文消息
 * @author 王治
 * @date 2017年6月17日
 */
public class NewsMessage extends BaseMessage {
	//图文消息个数，限制为8条以内
	private int ArticleCount;
	//条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
	private List<Articles> Articles;
	/**
	 * @return the articleCount
	 */
	public int getArticleCount() {
		return ArticleCount;
	}
	/**
	 * @param articleCount the articleCount to set
	 */
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	/**
	 * @return the articles
	 */
	public List<Articles> getArticles() {
		return Articles;
	}
	/**
	 * @param articles the articles to set
	 */
	public void setArticles(List<Articles> articles) {
		Articles = articles;
	}
}
