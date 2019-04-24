package com.hys.es;

import com.hys.mybatis.MybatisApplication;

import com.hys.utils.PoValidateUtils;
import com.hys.utils.ServiceResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.DeleteQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchPhraseQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;
import static org.elasticsearch.index.query.QueryBuilders.nestedQuery;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;
import static org.elasticsearch.index.query.QueryBuilders.termsQuery;

/**
 * 测试点 根据对象创建mapping
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
public class EsTest {


    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;



    @Test
    public void test(){
        System.out.println();
    }

    @Before
    public void init(){
        boolean index = elasticsearchTemplate.createIndex(Person.class);
        System.out.println(index);
        boolean putMapping = elasticsearchTemplate.putMapping(Person.class);
        System.out.println(putMapping);

    }

    @Test
    public void insertOrUpdate(){

        List<Person> personList = new ArrayList <>();
        for(int i = 0;i<100;i++){
            Date randomDate = RandomDate.randomDate("2007-01-01", "2007-03-01",1).get(0);

            String  sex = new Random().nextBoolean()?"male": "female";
            personList.add(new Person().setId(UUID.randomUUID().toString()).setBirthDay(randomDate
            ).setChnName("郝亚森"+i).setEnName("ahys"+i).setIdCard(UUID.randomUUID().toString()).setSex(sex).setProvince(new Province().setEnName("HeBei").setChnName("河北")));
        }

        List<IndexQuery> queries = new ArrayList<IndexQuery>();
        for (Person person : personList) {
           // ServiceResponse serviceResponse = PoValidateUtils.fastValidateResponse(person);
            IndexQuery indexQuery = new IndexQueryBuilder().withId(person.getId()).withObject(person).build();
            queries.add(indexQuery);
        }
        elasticsearchTemplate.bulkIndex(queries);
    }

    @Test
    public void del(){
        DeleteQuery deleteQuery = new DeleteQuery();
        deleteQuery.setIndex("com.hys.index");
        deleteQuery.setType("person");
        deleteQuery.setQuery(matchAllQuery());
        elasticsearchTemplate.delete(deleteQuery);
    }

    @Test
    public void query(){
        BoolQueryBuilder boolQueryBuilder = boolQuery();
        //term 查询关键词是否存在,不进行分词
        boolQueryBuilder.must(termQuery("sex","male"))
        .must(matchPhraseQuery("chnName","亚森"))
        .mustNot(matchQuery("1","chnName")).should(termsQuery("enName","ahys8"));
        SearchQuery searchQuery= new NativeSearchQueryBuilder().withQuery(boolQueryBuilder).build();
        searchQuery.setPageable(PageRequest.of(1,10, Sort.by(Sort.Order.asc("birthDay"))));
        List <Person> personList = elasticsearchTemplate.queryForList(searchQuery, Person.class);
        System.out.println(personList.size());
        personList.forEach(f->{
            System.out.println(f);
        });
    }



}
