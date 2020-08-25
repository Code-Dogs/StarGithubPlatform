[//]: # (调研文档)

## 几个重要的api
1. github第三方授权实现方案，最终获取token令牌实现认证：https://www.ruanyifeng.com/blog/2019/04/github-oauth.html
2. github rest api 关注相关api ： https://developer.github.com/v3/activity/starring/
	* List repositories starred by the authenticated user
	* Check if a repository is starred by the authenticated user
	* Star a repository for the authenticated user
	* List stargazers

	其中，Check if a repository is starred by the authenticated user 可以检查仓库是否被用户star
	
	List repositories starred by the authenticated user 用户展示用户star的仓库列表
	
	Star a repository for the authenticated user 用于为用户自动star
	
	 List stargazers 用于为仓库列出所有star的用户
	



