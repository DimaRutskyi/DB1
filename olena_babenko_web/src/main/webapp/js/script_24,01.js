/**
 * Created by lenchi on 24.01.16.
 */
/*КЛАССЫ*/
function Class(){
    this.field = 12;
    this.method = function(){//метод, возвращающий свойство - геттер; метод, устанавливающий св-во - сеттер
        this.field = 45;
        return this.field;
    }
}

var obj = new Class();
//alert(obj.field+obj.method());//12+45 = 57


/*ПРОТОТИПНОЕ НАСЛЕДОВАНИЕ*/

var sub = Object.create(obj);//внутри передаем объект, который будет "прототипом" для объекта sub
//alert(sub.field);//обращаемся к полю в наследнике, который объявлен в прототипе

//-----------------------------------------------------------------------------------------------
/*Меняем предка*/

var vector = new Array(3);
sub._proto_= vector; //изменили предка
sub._proto_=v;
//alert(sub.field);

//Альтернативный способ (для IntExplorer)
//sub.prototype(vector);//должно быть обявлено в конструкторной функции, чтобы работать!

alert(sub.hasOwnProperty('field'));//проверяет, пришло это св-во от прототипа или было обявлено в этом объекте.
// При делите можно удалить только собственный св-ва, св-ва прототипа остаются
