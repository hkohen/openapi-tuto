openapi-generator generate -g spring \
  --library spring-boot \
  -p groupId=com.hk.api \
  -p artifactId=demo \
  -p artifactVersion= 0.0.1-SNAPSHOT \
  \
  -p basePackage= com.hk.api.demo \
  -p configPackage= com.hk.api.demo.config \
  -p apiPackage= com.hk.api.demo.controler \
  -p moodelPackage= com.hk.api.demo.bo \
  \
  -p sourcefolder= src/main/java \
  \
  -p dateLibarary=java8 \
  -p java8=true \
  -i book-openapi.yaml \
  -o ${PWD}