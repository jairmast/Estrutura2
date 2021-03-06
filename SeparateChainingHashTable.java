
package aplicaçãohash;
import java.util.*;


public class SeparateChainingHashTable {
    private LinkedList[ ] theLists;
    private static final int DEFAULT_TABLE_SIZE = 101;
    public SeparateChainingHashTable( ) {
        this( DEFAULT_TABLE_SIZE );
    }
    public SeparateChainingHashTable( int size ) {
        theLists = new LinkedList[nextPrime(size)]; // Garante que o tamanho é primo
        for( int i = 0; i < theLists.length; i++ )
            theLists[ i ] = new LinkedList( );
    }
    public void makeEmpty( ) {
    for( int i = 0; i < theLists.length; i++ )
        theLists[ i ].clear( );
    }
    private static int nextPrime( int n ) {
    if( n % 2 == 0 )
        n++;
    for( ; !isPrime(n); n+=2)
    ;
    return n;
    }
    private static boolean isPrime( int n ) {
    if( n == 2 || n == 3 )
        return true;
    if( n == 1 || n % 2 == 0 )
        return false;
    for( int i = 3; i * i <= n; i+=2)
        if( n % i == 0 )
        return false;
    return true;
    }
    public void insert( Hashable x ) {
    LinkedList whichList = theLists[ x.hash(theLists.length ) ];
    if (whichList.indexOf(x)==-1) // equals será usado aqui
        whichList.add(0,x);
    }
    public void remove( Hashable x ) {
    theLists[ x.hash( theLists.length )].remove(x);
    }
    public Hashable find( Hashable x ) {
        int Position;
        Position = theLists[ x.hash(theLists.length)].indexOf(x);
    return (Hashable)theLists[ x.hash(theLists.length)].get(Position); // equals será usado aqui
    }


    
}
