-- PRODUCT_TYPE
CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE
  (null,
  'PRODUCT_TYPE',
  'D:\\GitHubRepos\\book_ap_archi_repo\\16_06_java_batch_sales\\sql\\csv\\PRODUCT_TYPE.csv',
  ',',
  '%',
  'UTF-8',
  0);

-- PRODUCT
CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE
  (null,
  'PRODUCT',
  'D:\\GitHubRepos\\book_ap_archi_repo\\16_06_java_batch_sales\\sql\\csv\\PRODUCT.csv',
  ',',
  '%',
  'UTF-8',
  0);

-- PRODUCT_NEW_PRICE
CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE
  (null,
  'PRODUCT_NEW_PRICE',
  'D:\\GitHubRepos\\book_ap_archi_repo\\16_06_java_batch_sales\\sql\\csv\\PRODUCT_NEW_PRICE.csv',
  ',',
  '%',
  'UTF-8',
  0);

-- STOCK_PRODUCT
CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE
  (null,
  'STOCK_PRODUCT',
  'D:\\GitHubRepos\\book_ap_archi_repo\\16_06_java_batch_sales\\sql\\csv\\STOCK_PRODUCT.csv',
  ',',
  '%',
  'UTF-8',
  0);

-- BRANCH
CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE
  (null,
  'BRANCH',
  'D:\\GitHubRepos\\book_ap_archi_repo\\16_06_java_batch_sales\\sql\\csv\\BRANCH.csv',
  ',',
  '%',
  'UTF-8',
  0);

-- STAFF
CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE
  (null,
  'STAFF',
  'D:\\GitHubRepos\\book_ap_archi_repo\\16_06_java_batch_sales\\sql\\csv\\STAFF.csv',
  ',',
  '%',
  'UTF-8',
  0);

-- CUSTOMER
CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE
  (null,
  'CUSTOMER',
  'D:\\GitHubRepos\\book_ap_archi_repo\\16_06_java_batch_sales\\sql\\csv\\CUSTOMER.csv',
  ',',
  '%',
  'UTF-8',
  0);

-- SALES_TRAN
CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE
  (null,
  'SALES_TRAN',
  'D:\\GitHubRepos\\book_ap_archi_repo\\16_06_java_batch_sales\\sql\\csv\\SALES_TRAN.csv',
  ',',
  '%',
  'UTF-8',
  0);

-- SALES_DETAIL
CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE
  (null,
  'SALES_DETAIL',
  'D:\\GitHubRepos\\book_ap_archi_repo\\16_06_java_batch_sales\\sql\\csv\\SALES_DETAIL.csv',
  ',',
  '%',
  'UTF-8',
  0);
