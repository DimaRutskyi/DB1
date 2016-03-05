package scrum.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ScrumServiceImpl implements ScrumService {
    @Override
    public List<Integer> StringToArray(String string) {
        List<Integer> array = new ArrayList<>();
        String[] items = string.split(" ");

        for ( int i = 0; i < items.length; i++ ) {
           try {
               array.add(Integer.parseInt(items[i]));
           } catch (Exception e) {
               return null;
           }
        }

        return array;
    }
}