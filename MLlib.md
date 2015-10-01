# MLlib
目前支持4种常见的机器学习问题
- 分类
- 回归
- 聚类
- 协同过滤

Spark将机器学习算法都分成了两个模块
- 训练模块: 通过训练样本输出模型参数
- 预测模块: 利用模型参数初始化，预测测试样本，输出与测值

## MLbase的分层结构
- ML Optimize
- MLI
- MLlib
- Spark

MLlib支持本地的密集向量和稀疏向量，并支持标量向量。

MLlib同时支持本地矩阵和分布式矩阵，支持的分布式矩阵分为RowMatrix、IndexedMatrix、CoorinateMatrix等。

# K-Means解析和实战
聚类（Cluster Analysis）

K-Means聚类属于无监督学习。

分类是势力式学习。

K-Means是聚类的一个算法，是一个无监督学习，目标是将一部分实体根据某种意义上的相似度和另外一部分实体聚在一起。 聚类通常被用于探索性的分析。

# 协同过滤算法分析
## 基于模型的协同过滤推荐
## 混合的推荐机制
## 推荐在电子商务中的引用
- 今日推荐（`Today's Recommendation For You`)
- 新产品的推荐(`New For You`) 采用基于内容的推荐机制（`Content-based Recommendation`)，将一些新到物品推荐给用户。在方法选择上由于新物品没有大量的用户喜好信息，所以基于内容的推荐能很好地解决这个**冷启动**的问题。
- 捆绑销售(Frequently Bought Together)
- 别人购买或浏览的商品(Customers Who Bought/See this Item Aslo Bought/See) 基于项目的协同过滤推荐的应用，通过社会化机制用户能更快更方便地找到自己感兴趣的物品。
- 利用大量历史数据的优势，量化推荐原因
- 基于社会化的推荐，给你事实的数据，让用户信服
- 基于物品本身的推荐，列出推荐的理由
- BTW，基于用户的profile计算出来，用户profile记录了用户在电商网站的行为
  - 看了那些物品
  - 买了那些物品
  - 收藏夹
  - 心愿单里的物品（wish list）
